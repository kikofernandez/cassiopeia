(ns cassiopeia.controllers.rest
  (:use [compojure.core :only (defroutes)])
  (:require [compojure.core :as compoj]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [sandbar.stateful-session :as session]))

(defroutes routes
  (compoj/GET "/" [] ("hola"))
  (compoj/GET "/hello" [] ("hola"))
  (compoj/POST "/api/user/questionnaire/save" {body :body}
               ; how to read json receiving:
               ; [{id 1, title "Jaja"} {id 2, title "Jojo"} ...]
               (println ((first body) "title"))
               (println (session/session-get :user))

               ; using Cheshire to map the received json into a dict {:id 1}
               ;(println ((json/parse-string (json/generate-string (first body)) true) :title))

               ; response in json using Cheshire
               ;(str (json/generate-string body))))

               ; response using ring-json
               ;{:body body}
               (resp/response body)))