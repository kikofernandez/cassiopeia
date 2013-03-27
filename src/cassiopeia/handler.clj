(ns cassiopeia.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [hiccup.page :as hpage]
            [hiccup.core :as hcore]
            [cassiopeia.controllers.public :as public]
            [cassiopeia.controllers.private :as private]
            [cassiopeia.controllers.rest :as rs]
            ))

;; Application routes, just simple website
(defroutes app-routes
  public/routes
  private/routes
  (route/resources "/")
  (route/not-found "Not Found"))

;; REST routes
;(defroutes api-routes
  ;(context "/api/" [] rs/routes)
  ;(route/not-found "Not Found")
  ;(context "/api" [] (defroutes documents
  ;                      (GET "/" [] ("jajaja"))))
;  )

(def app
;  (handler/api api-routes))
  (handler/site app-routes) ; web
  ;(-> (handler/api api-routes) ; REST
  ;    (middleware/wrap-json-response)
  ;    (middleware/wrap-json-body))
      )
  