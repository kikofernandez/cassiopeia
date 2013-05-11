(ns cassiopeia.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.middleware.params :as params]
            [ring.util.response :as resp]
            [cassiopeia.controllers.db :as db]
            [cassiopeia.controllers.public :as public]
            [cassiopeia.controllers.private :as private]
            ;[cassiopeia.controllers.rest :as rs]
            [sandbar.stateful-session :as session]
            ;[cheshire.core :as json]
            ))

(defn- stateful-route
  "Calls the routeFn adding stateful session."
  [routeFn]
   (-> routeFn
      session/wrap-stateful-session
      params/wrap-params))

(defn- site-stateful
  [route]
  (handler/site (stateful-route route)))

;; Application routes, just simple website
(defroutes app-routes
  (site-stateful public/routes)
  (site-stateful private/routes)
  (-> (handler/api(POST "/api/user/questionnaire/save" {body :body}
                        ; how to read json receiving:
                        ; [{id 1, title "Jaja"} {id 2, title "Jojo"} ...]
                        (println ((first body) "title"))

                        ; using Cheshire to map the received json into a dict {:id 1}
                        ;(println ((json/parse-string (json/generate-string (first body)) true) :title))

                        ; response in json using Cheshire
                        ;(str (json/generate-string body))))

                        ; response using ring-json
                        ;{:body body}
                        (resp/response body)))
      (middleware/wrap-json-response)
      (middleware/wrap-json-body))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  app-routes)
