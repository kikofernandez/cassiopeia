(ns cassiopeia.views.private
  (:require [cassiopeia.views.layout :as layout]
            [hiccup.page :as hpage]
            [clojure.set :as closet]
            [cassiopeia.models.private :as mprivate]))

(defn- type-account-html 
  "Creates the header with a welcome message and the kind of account that you have"
  [user]
  (let [inverted-map (closet/map-invert mprivate/accounts)
        account (:account user)]
    (hpage/html5 
     [:div {:class "panel"}
      "Welcome back " (:first_name user) ", you are using a " (inverted-map account)])))

(defn- valid-actions 
  "Display the actions that you can do now that you are a registered user"
  [user]
  (hpage/html5 
   [:ul {:class "button-group"}
    [:li [:a {:class "small button secondary" :href "/user/category"}"Create Category"]]
    [:li [:a {:class "small button secondary" :href "/user/questionnaire"} "Create new questionnaire"]]
    [:li [:a {:class "small button secondary" :href "/user/documents"} "My Documents"]]]
   [:div {:class "panel"}
    (mprivate/all user)]))

(defn welcome [user]
  (layout/common (str "Welcome " (:name user))
                 (type-account-html user)
                 (valid-actions user)))