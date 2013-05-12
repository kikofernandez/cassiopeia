(ns cassiopeia.views.private
  (:require [cassiopeia.views.layout :as layout]
            [hiccup.page :as hpage]
            [hiccup.form :as form]
            [clojure.set :as closet]
            [sandbar.stateful-session :as session]
            [cassiopeia.controllers.db :as db]
            [cassiopeia.controllers.urls :as urls]
            [cassiopeia.models.private :as mprivate]))

;;;;;;;;;;;;;;;;;;;;;;;;
;; CONSTS
;;;;;;;;;;;;;;;;;;;;;;;;
(def title-new-questionnaire "Create new questionnaire")
(def title-my-questions "My questions")

(def my-actions
  [:ul {:class "button-group"}
    [:li [:a {:class "small button secondary" :href urls/user-category}"Create Category"]]
    [:li [:a {:class "small button secondary" :href urls/user-questionnaire-new} "Create new questionnaire"]]
    [:li [:a {:class "small button secondary" :href urls/user-documents} "My Documents"]]])


;;;;;;;;;;;;;;;;;;;;;;;;
;; PRIVATE METHODS
;;;;;;;;;;;;;;;;;;;;;;;;

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
  (hpage/html5 my-actions
               (when (<= db/latest (count question))
                 [:div {:class "panel"}
                  [:p "Latest " db/latest " questions added: "]
                  [:ul (map (fn [user] [:li (:title user)]) (take-last db/latest question))]])))


(defn- create-questionnaire-form []
  (hpage/html5
   [:div {:ng-app "project"}
    (hpage/include-js "https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.min.js")
    (hpage/include-js "https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular-resource.min.js")
    (hpage/include-js "/js/angular/questionnaire.js")
    (hpage/include-js "/js/angular/questionnaireService.js")
    [:div {:ng-view ""}]
    ]))

(defn- display-all-questions
  [questions]
  (hpage/html5 my-actions
   [:ul
    (map (fn [question]
           [:li (question :title)]) questions)]))

;;;;;;;;;;;;;;;;;;;;;;;;
;; PUBLIC METHODS
;;;;;;;;;;;;;;;;;;;;;;;;

(defn welcome [question]
  (let [session-user (session/session-get :user)]
      (layout/common (str "Welcome " (:first_name session-user))
                 (type-account-html session-user)
                 (valid-actions question))))

(defn new-questionnaire []
  (layout/common title-new-questionnaire
                 (create-questionnaire-form)))

(defn display-questions
  [user]
  (layout/common title-my-questions
                 (type-account-html user)
                 (let [questions (mprivate/all user)]
                   (display-all-questions questions))))
