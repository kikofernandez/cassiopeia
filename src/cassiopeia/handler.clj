(ns cassiopeia.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [hiccup.page :as hpage]
            [hiccup.core :as hcore]
            [cassiopeia.controllers.public :as public]
            [cassiopeia.controllers.rest :as rs]
            ))

;; Application routes, just simple website
(defroutes app-routes
  public/routes
  (route/resources "/")
  (route/not-found "Not Found"))

;; REST routes
(defroutes api-routes
  (context "/api/" [] rs/routes)
  (route/not-found "Not Found"))

(def app
  ;(handler/site app-routes) ; web
  (-> (handler/api api-routes) ; REST
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
  