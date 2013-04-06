(ns cassiopeia.models.public
  (:require [hiccup.page :as hpage]
            [monger.collection :as mc]
            [cassiopeia.controllers.db :as db]
            ))

(defn introduction 
  "Dummy example. The :first argument is the title of the
  website and the rest makes the body"
  []
  ["Welcome to Cassiopeia"])