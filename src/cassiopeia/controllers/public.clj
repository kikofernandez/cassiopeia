(ns cassiopeia.controllers.public
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [cassiopeia.controllers.db :as db]
            [cassiopeia.views.public :as view]
            [cassiopeia.models.public :as mpublic]
            [ring.util.response :as response]
            [sandbar.stateful-session :as session]
            [cassiopeia.controllers.urls :as urls]
            ))

(defn- index 
  "We create the welcome / index page with this fn."
  []
  ;; we use apply in order to de-structure the content that
  ;; will be executed in layout/common. Thereby, layout/common
  ;; accepts a list of arguments where we treat them as [& content],
  ;; meaning, it will create a new list, ending up (["text" "..."]).
  ;; In order to de-structure this, we use the apply method over the
  ;; fn that accepts and creates the new structure.
  db/connect
  (apply view/index (mpublic/introduction))
  ;db/disconnect
  )

(defn- features
  "Display the features."
  []
  (view/features))

(defn- waiting-list
  "Display a form for the waiting list"
  []
  (view/waiting-list))

(defn- login
  []
  (view/login-view))

(defn- login-validate
  [{:keys [email password]}]
  (when-let [user (first (db/login-user email password))]
    (session/session-put! :user user)
    (response/redirect urls/user-welcome)))

(defroutes routes
  (GET "/" [] (index))
  (GET urls/home [] (index))
  (GET urls/login [] (login))
  (POST urls/login [& params] (println params)(login-validate params))
  (GET urls/features [] (features))
  (GET urls/waitinglist [] (waiting-list)))
