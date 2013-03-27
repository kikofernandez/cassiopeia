(ns cassiopeia.controllers.rest
  (:use [compojure.core :only (defroutes)])
  (:require [compojure.core :as compoj]
            [compojure.route :as route]
            [ring.util.response :as resp]))

;(defroutes rest-api-route
;  (compoj/GET "hello" [] (example)))

(defroutes routes
  (compoj/GET "/" [] ("hola"))
  (compoj/GET "/hello" [] ("hola"))
  ;(route/not-found "Not Found")
  )