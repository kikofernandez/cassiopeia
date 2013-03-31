(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [ring.util.response :as response]
            [hiccup.core :as hcore]
            [hiccup.page :as hpage]
            [hiccup.form :as form]
            [sandbar.stateful-session :as session]))

(defn index [id]
  (let [counter (+ 1 (session/session-get :counter 0))]
    (do
      (session/session-put! :counter counter)
      (hpage/html5 [:p "Hi there: " id " end " (session/session-get :counter) " .s"]))))

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