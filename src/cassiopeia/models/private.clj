(ns cassiopeia.models.private
  (:require [monger.collection :as mc]))

(def free-account 0)

(def small-account 1)

(def premium-account 2)


(def accounts
  {:free-account free-account
   :small-account small-account
   :premium-account premium-account})

(defn user-model 
  "Creates a user model to be populated with information"
  [{:as attributes}]
   (merge {:name "" 
           :first_name "Janina" 
           :last_name "" 
           :account (accounts :free-account)}
          attributes))

(defn category
  "Creates a category (top-level folder)"
  [{:as attributes}]
   (merge {:name "Documents"
           :description "Default category"
           :tags ["documents" "default"]} 
          attributes))


;(defn item
;  [namee text & solutions]
;  (map :name solutions))

;(item "Kiko" "Fernandez" {:name "Kiko" :lastname "Fernandez"} {:name :kiko})

(defn item
  "Defines a item, which is a question and a list of valid answers"
  [{:as attributes}]
  (merge {:name "Enter a name" 
          :description "Enter a description"
          :answers []}
         attributes))

(defn all
  "Display all valid questions. 
  A valid question is a question that has a title."
  [user]
  (filter :title (mc/find-maps "question" {:first_name (:first_name user)})))