(ns immutant.init
  (:require [immutant.web :as web])
  (:use ;[ring.middleware.resource :only [wrap-resource]]
        ;[ring.util.response :only [redirect]])
        cassiopeia.handler))

;(defn handler [request]
;  (redirect "/index.html"))

;(immutant.web/start (wrap-resource handler "public"))
;(immutant.web/start handler/app)
(web/start ring-handler)
