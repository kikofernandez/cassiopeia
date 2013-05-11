(ns cassiopeia.controllers.rest
  (:use [compojure.core :only (defroutes)])
  (:require [compojure.core :as compoj]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [sandbar.stateful-session :as session]
            [cassiopeia.models.private :as model]))

(defn- save-questionnaire
  [{:keys [user questionnaire] :as data}]
  (doseq [i (range (count questionnaire))]
    (println (model/question i data))
    )
;  (map (model/question) )
  ;(model/save-question {:first_name (:first_name user)
  ;                      :last_name (:last_name user)
  ;                      :title ("xxx")
  ;                      })
  )


(defroutes routes
  (compoj/GET "/" [] ("hola"))
  (compoj/GET "/hello" [] ("hola"))
  (compoj/POST "/api/user/questionnaire/save" {body :body}
               ; how to read json receiving:
               ; [{id 1, title "Jaja"} {id 2, title "Jojo"} ...]
               (println ((first body) "title"))
               (println (session/session-get :user))
               ;(println {:user (session/session-get :user nil),
               ;                     :questionnaire body})
               (save-questionnaire {:user (session/session-get :user nil),
                                    :questionnaire body})

               ; using Cheshire to map the received json into a dict {:id 1}
               ;(println ((json/parse-string (json/generate-string (first body)) true) :title))

               ; response in json using Cheshire
               ;(str (json/generate-string body))))

               ; response using ring-json
               ;{:body body}
               (resp/response body)))