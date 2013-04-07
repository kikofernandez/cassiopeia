(ns cassiopeia.views.private
  (:require [cassiopeia.views.layout :as layout]
            [hiccup.page :as hpage]
            [clojure.set :as closet]
            [sandbar.stateful-session :as session]
            [cassiopeia.controllers.db :as db]
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
  [question]
  (hpage/html5 
   [:ul {:class "button-group"}
    [:li [:a {:class "small button secondary" :href "/user/category"}"Create Category"]]
    [:li [:a {:class "small button secondary" :href "/user/questionnaire"} "Create new questionnaire"]]
    [:li [:a {:class "small button secondary" :href "/user/documents"} "My Documents"]]]
    (when (<= db/latest (count question))
      [:div {:class "panel"}
       [:p "Latest " db/latest " questions added: "]
       [:ul (map (fn [user] [:li (:title user)]) (take-last db/latest question))]])))

(defn welcome [question]
  (let [session-user (session/session-get :user)]
      (layout/common (str "Welcome " (:first_name session-user))
                 (type-account-html session-user)
                 (valid-actions question))))