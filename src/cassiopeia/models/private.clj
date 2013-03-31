(ns cassiopeia.models.private)

(def free-account 0)

(def small-account 1)

(def premium-account 2)

(defn user-model 
  "Creates a user model to be populated with information"
  [{:as attributes}]
  (atom (merge {:name "" :account free-account} attributes)))

