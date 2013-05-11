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
            [cassiopeia.controllers.rest :as rs]
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
  (-> (handler/api rs/routes)
      (middleware/wrap-json-response)
      (middleware/wrap-json-body))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  app-routes)
