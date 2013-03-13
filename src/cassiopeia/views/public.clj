(ns cassiopeia.views.public
  (:require [hiccup.page :as hpage]
            [hiccup.form :as form]
            [hiccup.element :as element]
            [cassiopeia.views.layout :as layout]))

(def feature-description
  (hpage/html5 [:div 
                [:h1 "Welcome to the most advance survey creator application"]]

               ; slider
               [:ul {:data-orbit ""}
                [:li 
                 (element/image "/img/html5-badge.png")
                 [:div {:class "orbit-caption"} "Welcome to HTML5, welcome to the future"]]
                [:li
                 (element/image "/img/sencha-touch-2-devices-400.jpg")
                 [:div {:class "orbit-caption"} 
                  "Build with the latest technology. Build one, deploy anywhere"]]
                [:li
                 (element/image "/img/sencha-tools-250.png")
                 [:div {:class "orbit-caption"} "Proud of using Sencha Framework"]]]

               ;Bottom Feature panels
               [:div {:class "row"}
                [:div {:class "large-4 columns"}
                 [:div {:class "panel"}
                  "Welcome to HTML5, welcome to the future"
                 (element/image "/img/html5-badge.png")]]
                [:div {:class "large-4 columns"} 
                 [:div {:class "panel"}
                   "Build with the latest technology. Build one, deploy anywhere"
                   (element/image "/img/sencha-touch-2-devices-400.jpg")]]
                [:div {:class "large-4 columns"} 
                 [:div {:class "panel"}
                   "Proud of using Sencha Framework"
                   (element/image "/img/sencha-tools-250.png")]]]))

(def feature-showcase
  (hpage/html5 [:div {:class "row"}
                [:div {:class "large-10 large-offset-1"} 
                 [:h1 "Features"]
                 [:div {:class "large-7"}
                  [:h1 "asdasda asdasdasd asdas dasd asd asd"]]
                 [:div {:class "large-7 large-offset-5"}
                  [:h1 "asdasda asd sdsad sdsd asdas dasd asd asd"]]]]))

(def waiting-list-view
  (hpage/html5 [:div {:class "row"}
                [:div {:class "large-10 large-offset-1"}
                 [:h1 "Waiting List"]
                 [:div {:class "panel"} (element/image "/img/sencha-touch-2-devices-400.jpg")
                  [:div {:class "large-7 panel"} 
                   (form/label "email-label" "Subscribe to the waiting list")
                   (form/email-field "email" "Enter your e-mail")]]]]))

(defn index [& content]
    (apply layout/common (into (into [] content)
                               feature-description)))

(defn features []
  (apply layout/common (-> ["Company name - Features"] (into feature-showcase))))
;    (apply layout/common (into ["Company name - Features"] feature-showcase)))

(defn waiting-list []
  (apply layout/common (into ["Company name - Waiting list"] waiting-list-view)))