(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [cassiopeia.models.private :as models]
            [sandbar.stateful-session :as session]
            [cassiopeia.views.private :as views]
            [cassiopeia.models.private :as mprivate]))

(defn index []
  (-> (session/session-get :user) (mprivate/all) (views/welcome)))

(defroutes controller-routes
  (GET "/welcome/" [] (index)))

(defroutes routes
  (context "/user" [] controller-routes))