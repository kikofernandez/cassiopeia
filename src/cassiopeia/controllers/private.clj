(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [ring.util.response :as response]
            [hiccup.core :as hcore]
            [hiccup.page :as hpage]
            [hiccup.form :as form]
            [cassiopeia.models.private :as models]
            [sandbar.stateful-session :as session]
            [cassiopeia.views.private :as views]))

;(defn index [id]
;  (let [user (session/session-get :user (models/user-model {:name "Kiko"}))]
;    (do
;      ;(session/session-put! :counter counter)
;      (hpage/html5 [:p "Hi there: " id " end " (@user :name) " - " (@user :account)]))))

(defn index
  ([] (let [user (session/session-get :user (models/user-model {:name "Kiko"}))]
          (views/welcome user)))
  ([id] (let [user (session/session-get :user (models/user-model {:name "Kiko"}))]
          (views/welcome user))))


(defroutes controller-routes
  (GET "/welcome/" [] (index))
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