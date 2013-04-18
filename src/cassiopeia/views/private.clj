(ns cassiopeia.views.private
  (:require [cassiopeia.views.layout :as layout]
            [hiccup.page :as hpage]
            [hiccup.form :as form]
            [clojure.set :as closet]
            [sandbar.stateful-session :as session]
            [cassiopeia.controllers.db :as db]
            [cassiopeia.controllers.urls :as urls]
;            [cassiopeia.controllers.private :as controller]
            [cassiopeia.models.private :as mprivate]))

(def title-new-questionnaire "Create new questionnaire")

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
    [:li [:a {:class "small button secondary" :href urls/user-category}"Create Category"]]
    [:li [:a {:class "small button secondary" :href urls/user-questionnaire} "Create new questionnaire"]]
    [:li [:a {:class "small button secondary" :href urls/user-documents} "My Documents"]]]
    (when (<= db/latest (count question))
      [:div {:class "panel"}
       [:p "Latest " db/latest " questions added: "]
       [:ul (map (fn [user] [:li (:title user)]) (take-last db/latest question))]])))

(defn welcome [question]
  (let [session-user (session/session-get :user)]
      (layout/common (str "Welcome " (:first_name session-user))
                 (type-account-html session-user)
                 (valid-actions question))))

(defn- create-questionnaire-form []
  (hpage/html5
   [:div {:ng-app "project"}
    (hpage/include-js "https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular.min.js")
    (hpage/include-js "https://ajax.googleapis.com/ajax/libs/angularjs/1.0.6/angular-resource.min.js")
    (hpage/include-js "/js/angular/questionnaire.js")
    [:div {:ng-view ""}]
    (comment
      [:div {:ng-controller "QuestionnaireCtrl"}
       [:ul {:class "unstyled"}
        [:li {:ng-repeat "question in questions"}
         [:span "{{ question.title }}<br>"]
         [:span {:ng-repeat "answer in question.answers "} 
          "{{ answer.title}}<br>"]
         [:div {:ng-controller "AnswerCtrl"}
          (form/form-to {:ng-submit "addAnswer(question)"} ["" ""]
                       (form/text-field {:placeholder "Respuesta" :ng-model "answerTitle"} "answerTitle")
                       (form/text-field {:placeholder "Valor (opcional)" :ng-model "answerValue"} "answerValue")
                       (form/submit-button "Añadir Respuesta"))]
         ]]
       (form/form-to {:ng-submit "addQuestion()"} ["" ""]
                     (form/text-field {:placeholder "título" :ng-model "questionTitle"} "questionTitle")
                     (form/submit-button "Añadir"))
       (form/form-to [:post (str urls/user urls/questionnaire-new)]
                     (form/submit-button "Send"))])
    ]))

(defn new-questionnaire []
  (layout/common title-new-questionnaire
                 (create-questionnaire-form)))