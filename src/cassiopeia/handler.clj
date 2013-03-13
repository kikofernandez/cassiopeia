(ns cassiopeia.handler
  (:use compojure.core)
;  (:require [compojure.handler :as handler]
            ;[compojure.route :as route]
            ;[hiccup.page :as hpage]
            ;[hiccup.core :as hcore])
    )

;(defroutes app-routes
;  public/routes
;  (route/resources "/")
;  (route/not-found "Not Found"))

;(def app
;  (handler/site app-routes))
  
(defn ring-handler [request]
  {:status 200
    :headers {"Content-Type" "text/html"}
    :body "Hello from Immutant!" })