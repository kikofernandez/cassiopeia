(ns cassiopeia.views.public
  (:require [hiccup.page :as hpage]
            [hiccup.form :as form]
            [hiccup.element :as element]
            [cassiopeia.views.layout :as layout]
            [cassiopeia.controllers.urls :as urls]))

(def feature-description
  (hpage/html5 [:div 
                [:h1 "We enlighten your business"]]

               ; slider
               [:div {:class "row"}
                [:div {:class "large-7 columns"}
                 (element/image "/img/sencha-touch-2-devices-400.jpg")]
                
                [:div {:class "panel radius large-5 columns"} 
                 [:p "Hemos creado la aplicación perfecta para aquellos negocios que
                  necesitan realizar inventario de forma rápida y sencilla"]]]
               
               ;Bottom Feature panels
               [:div {:class "row"}
                [:div {:class "large-4 columns"}
                 [:div {:class "panel"}
                  [:p "Construido usando las últimas tecnologías y frameworks"]
                 (element/image {:height "100px"} "/img/technology.png")]]
                
                [:div {:class "large-4 columns"} 
                 [:div {:class "panel"}
                   [:p "Funciona en la nube, con modo offline y sincroniza cuando quieras"]
                   (element/image {:height "100px"} "/img/small-cloud.png")]]
                
                [:div {:class "large-4 columns"} 
                 [:div {:class "panel"}
                   [:p "Para ofrecerle una mayor flexibilidad utilizamos base de datos NoSQL"]
                   (element/image {:height "100px"} "/img/mongodb.jpg")]]]))

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
                    [:p "Cassiopeia está diseñada para funcionar bajo cualquier plataforma ofreciendo
                   el máximo rendimiento posible en cada una de ellas. Actualmente soportamos
                   Android y iOs."]]
                   [:div {:class "large-5 columns"}
                    (element/image "/img/Devices.png")]]
                  
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
                    (element/image "/img/online_to_offline_connection.png")]]
                  
                  ;; Fourth feature
                  [:div {:class "row"}
                   [:div {:class "large-5 columns"}
                    ;(element/image "img/Cloud.png")]
                    (element/image "img/ai.jpg")]
                   [:div {:class "large-7 columns"}
                    [:h3 "Let us think for you"]
                    [:p "Cassiopeia contiene un sistema experto que le mostrará datos
                     estadísticos presentes y, usando las más avanzadas técnicas en
                     Inteligencia Artificial, predicciones basadas en los datos recogidos."]]]
                  ]]]))

(def waiting-list-view
  (hpage/html5 [:div {:class "row"}
                [:div {:class "large-10 large-offset-1"}
                 [:h1 "Lista de espera"]
                 [:div {:class "panel"} (element/image "/img/sencha-touch-2-devices-400.jpg")
                  [:div {:class "large-7 panel"} 
                   (form/label "email-label" "Pide tú invitación aquí:")
                   [:input {:type "email" :name "email-invitation"
                            :placeholder "johndoe@cassiopeia.com"}]
                   ;(form/email-field "email" "johndoe@cassiopeia.com")
                   ]]]]))

(def login-form
  (form/form-to [:post urls/login ]
                (form/email-field {:placeholder "johndoe@cassiopeia.com"} "email")
                (form/password-field {:placeholder "********"} "password")
                (form/submit-button "Login")))

(def login-form-view
  (hpage/html5 [:div {:class "row"}
                [:div {:class "large-10 large-offset-1"}
                 [:h1 "Login"]
                 [:div {:class "panel"} (element/image "/img/sencha-touch-2-devices-400.jpg")
                  [:div {:class "large-7 panel"} 
                   login-form]]]]))

(defn index [& content]
    (apply layout/common (into (into [] content)
                               feature-description)))

(defn features []
  (apply layout/common (-> ["Cassiopeia - Características"] (into feature-showcase))))
;    (apply layout/common (into ["Company name - Features"] feature-showcase)))

(defn waiting-list []
  (apply layout/common (into ["Cassiopeia - Lista de espera"] waiting-list-view)))

(defn login-view []
  (apply layout/common (into ["Login"] login-form-view)))