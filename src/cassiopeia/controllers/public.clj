(ns cassiopeia.controllers.public
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [ring.util.response :as response]
            [hiccup.core :as hcore]
            [hiccup.page :as hpage]
            [hiccup.form :as form]
            [cassiopeia.views.public :as view]
            [cassiopeia.models.public :as mpublic]
            ))

(defn index 
  "We create the welcome / index page with this fn."
  []
  ;; we use apply in order to de-structure the content that
  ;; will be executed in layout/common. Thereby, layout/common
  ;; accepts a list of arguments where we treat them as [& content],
  ;; meaning, it will create a new list, ending up (["text" "..."]).
  ;; In order to de-structure this, we use the apply method over the
  ;; fn that accepts and creates the new structure.
  (apply view/index (mpublic/introduction)))

(defn features
  "Display the features."
  []
  (view/features))

(defn waiting-list
  "Display a form for the waiting list"
  []
  (view/waiting-list))

(defroutes routes
  (GET "/" [] (index))
  (GET "/home" [] (index))
  (GET "/features" [] (features))
  (GET "/waiting-list" [] (waiting-list)))