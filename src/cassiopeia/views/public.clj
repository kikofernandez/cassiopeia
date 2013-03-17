(ns cassiopeia.views.public
  (:require [hiccup.page :as hpage]
            [hiccup.form :as form]
            [hiccup.element :as element]
            [cassiopeia.views.layout :as layout]))

(def feature-description
  (hpage/html5 [:div 
                [:h1 "Bienvenido a la primera aplicación de retail"]]

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
                [:div {:class "large-11 large-offset-1"} 
                 [:h1 "Características"]
                 [:div {:class "large-11 columns"}
                  
                  ;; First feature
                  [:div {:class "row"}
                   [:div {:class "large-8 columns"}
                    [:h3 "Run everywhere"]]]
                  [:div {:class "row"}
                   [:div {:class "large-7 columns"}
;                    [:h2 "Run everywhere"]
                    [:p "Cassiopeia está diseñada para funcionar bajo cualquier plataforma ofreciendo
                   el máximo rendimiento posible en cada una de ellas. Actualmente soportamos
                   Android y iOs."]]
                   [:div {:class "large-5 columns"}
                    (element/image "/img/Devices.png")]]
                  
;                  [:div {:class "row"}
;                   [:div {:class "large-7 large-offset-5 columns"}
;                    [:h2 "We love the cloud"]]]
                  ;; Second feature
                  [:div {:class "row"}
                   [:div {:class "large-5 columns"}
                    ;(element/image "img/Cloud.png")]
                    (element/image "img/small-cloud-csci.png")]
                   [:div {:class "large-7 columns"}
                    [:h3 "We love the cloud"]
                    [:p "Cassiopeia funciona en la nube, de manera que siempre tendrá
                     a su disposición los datos sin necesidad de emplear complicadas instalaciones.
                     Los datos son privados y le pertenecen a usted, nosotros sólo nos 
                     encargamos de custodiarlos."]]]
                  
                  ;; Third feature
                  [:div {:class "row"}
                   [:div {:class "large-7 columns"}
                    [:h3 "Offline store"]
                    [:p "Utilice la aplicación estando offline y sincronice de forma
                      automática cuando tenga conexión. La sincronización es ahora un
                      juego de niños."]]
                   [:div {:class "large-5 columns"}
                    (element/image "/img/online_to_offline_connection.png")]]]
                 ;[:div {:class "large-7 large-offset-5"}
                 ; [:h2 "We love the Cloud"]
                 ; [:p "La aplicación funciona en la nube, de manera que siempre tendrá
                 ;  a su disposición los datos sin necesidad de emplear complicadas instalaciones.
                 ;  Los datos son privados y le pertenecen a usted, nosotros sólo nos 
                 ;  encargamos de custodiarlos."]]
                 
                 ;[:div {:class "large-7"}
                 ; [:h2 "Offline store"]
                 ; [:p "Utilice la aplicación estando offline y sincronice de forma
                 ;  automática cuando tenga conexión. La sincronización es ahora un
                 ;  juego de niños."]]
                 ]]))

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