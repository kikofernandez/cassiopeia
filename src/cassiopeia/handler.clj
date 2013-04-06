(ns cassiopeia.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            ;[ring.middleware.json :as middleware]
            [ring.middleware.params :as params]
            [cassiopeia.controllers.db :as db]
            [cassiopeia.controllers.public :as public]
            [cassiopeia.controllers.private :as private]
            ;[cassiopeia.controllers.rest :as rs]
            [sandbar.stateful-session :as session]
            ))

(defn- stateful-route
  "Calls the routeFn adding stateful session."
  [routeFn]
   (-> routeFn
      session/wrap-stateful-session 
      params/wrap-params))

;; Application routes, just simple website
(defroutes app-routes
  public/routes
  (stateful-route private/routes) ; stateful route, we have an user.
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
  