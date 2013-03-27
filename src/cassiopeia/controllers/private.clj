(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [ring.util.response :as response]
            [hiccup.core :as hcore]
            [hiccup.page :as hpage]
            [hiccup.form :as form]))

(defn index [id]
  (hpage/html5 [:p "Hola there: " id]))

(defroutes controller-routes
  (GET "/welcome/:id" [id] (index id)))

;; We define the routes for the meta-models 
(defroutes controller-model-routes
  (GET "/" [] (index "read models"))
  (GET "/create" [] (index "create model"))
  (GET "/edit/:id" [id] (index id))
  (GET "/delete/:id" [id] (index id)))

(defroutes routes
  (context "/user" [] controller-routes)
  (context "/model" [] controller-model-routes))