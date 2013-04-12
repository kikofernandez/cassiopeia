(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [cassiopeia.models.private :as models]
            [sandbar.stateful-session :as session]
            [cassiopeia.views.private :as views]
            [cassiopeia.controllers.urls :as urls]
            [cassiopeia.models.private :as mprivate]))

(defn index []
  (-> (session/session-get :user) (mprivate/all) (views/welcome)))

(defn- create-questionnaire []
  (views/new-questionnaire))

(defroutes controller-routes
  (GET urls/welcome [] (index))
  (GET urls/questionnaire-new [] (create-questionnaire)))

(defroutes routes
  (context "/user" [] controller-routes))