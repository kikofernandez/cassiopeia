(ns cassiopeia.controllers.private
  (:use [compojure.core :only (defroutes GET POST context)])
  (:require [cassiopeia.models.private :as models]
            [sandbar.stateful-session :as session]
            [cassiopeia.views.private :as views]
            [cassiopeia.models.private :as mprivate]))

;; url paths, this way they can be re-used without re-coding
(def welcome "/welcome")
(def questionnaire "/questionnaire")
(def new "/new")
(def user "/user")


(defn index []
  (-> (session/session-get :user) (mprivate/all) (views/welcome)))

(defn- create-questionnaire []
  (views/new-questionnaire))

(defroutes controller-routes
  (GET "/welcome" [] (index))
  (GET "/questionnaire/new" [] (create-questionnaire)))
;; This thing of using the urls in the controller and calling from it the views
;; and vice versa causes an infinite loop when loading the requirements.
;; We do better create a new file with the urls keywords
;  (GET welcome [] (index))
;  (GET (str questionnaire new) [] (create-questionnaire)))

(defroutes routes
  (context "/user" [] controller-routes))