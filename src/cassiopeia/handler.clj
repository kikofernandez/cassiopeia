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

(defn- site-stateful
  [route]
  (handler/site (stateful-route route)))

;; Application routes, just simple website
(defroutes app-routes
  ;(handler/site (stateful-route public/routes))
  ;(handler/site (stateful-route private/routes))
  (site-stateful public/routes)
  (site-stateful private/routes)
  ;(stateful-route public/routes)
  ;(stateful-route private/routes) ; stateful route, we have an user.
  (handler/site (POST "/api/user/questionnaire/save" [] (str "First step for a working API")))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  app-routes
;  (-> app-routes stateful-route handler/site)
  ;(-> (handler/api api-routes) ; REST
  ;    (middleware/wrap-json-response)
  ;    (middleware/wrap-json-body))
      )
