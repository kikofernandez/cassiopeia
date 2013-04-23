(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [cassiopeia.models.private :as models]
            [sandbar.stateful-session :as session]
            [cassiopeia.views.private :as views]
            [cassiopeia.controllers.urls :as urls]
            [cassiopeia.models.private :as mprivate]
            [ring.util.response :as response]))

(defn index []
  (-> (session/session-get :user) (mprivate/all) (views/welcome)))

(defn- create-questionnaire []
  (views/new-questionnaire))

(defn- save-questionnaire [questions]
  (println questions)
  (println "Kiko")
  (response/response "OK"))

(defn- display-list 
  ([] (str (session/session-get :user)))
  ([params]
  (str (session/session-get :user) params)))

(defroutes controller-routes
  (GET urls/welcome [] (index))
  (GET urls/questionnaire-new [] (create-questionnaire))
  (GET urls/questionnaire-save [] (display-list))
  (POST urls/questionnaire-save [& questions] (save-questionnaire questions))
  (POST urls/questionnaire-new [& params] (display-list params)))

(defroutes routes
  (context "/user" [] controller-routes))
