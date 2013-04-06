(ns cassiopeia.controllers.public
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [cassiopeia.controllers.db :as db]
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
  db/connect
  (apply view/index (mpublic/introduction))
  ;db/disconnect
  )

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