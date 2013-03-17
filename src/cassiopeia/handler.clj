(ns cassiopeia.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :as hpage]
            [hiccup.core :as hcore]
            [cassiopeia.controllers.public :as public]
            ;[cassiopeia.controllers.rest :as rs]
            ))

(defroutes app-routes
  public/routes
  ;rs/routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
  
;(defn ring-handler [request]
;  {:status 200
;    :headers {"Content-Type" "text/html"}
;    :body "Hello from Immutant!" })