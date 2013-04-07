(ns cassiopeia.views.layout
  (:require [hiccup.page :as hpage]
            ;[monger.collection :as mc]
            ;[monger.core :as mg]
            [hiccup.core :as hcore]))

(defn leftmenu
  "Defines the left menu on the welcome screen"
  []
  (hpage/html5 
   [:div {:class "section-container accordion" :data-section ""}
    [:section {:class "section"}
     [:p {:class "title"}
      [:a {:href "#"} "Section 1"]]
     [:div {:class "content"}
      [:p "Content of section 1"]]]
    [:section {:class "section"}
     [:p {:class "title"}
      [:a {:href "#"} "Section 2"]]
     [:div {:class "content"}
      [:p "Content of section 2"]]]]))


(defn toplink
  "Fn that creates the breadcrumbs on the top of the
  page. The breadcrumbs are supposed to be always the same
  and won't change, ever."
  []
  (hpage/html5
   [:div {:class "row"}
    [:div {:class "large-12 columns"}
     [:ul {:class "breadcrumbs"}
      ;[:li [:a {:href "/home"} (map :first_name (mc/find-maps "question"))]]
      [:li [:a {:href "/home"} "Home"]]
      [:li [:a {:href "/features"} "Características"]]
      [:li [:a {:href "/waiting-list"} "Invitación"]]]]]
   ))
   


(defn container
  "Creates the container of the page."
  [& body]
  (hpage/html5
   [:div {:class "row"}
     ;[:div {:class "large-3 columns"} (leftmenu)]
     ;[:div {:class "large-9 columns"}
     [:div {:class "large-10 large-offset-1 columns"}
      [:div {:id "container"} body]]]))

(defn head-js-css
  "Adds the Foundation Framework dependencies"
  []
  (hpage/html5
   (hpage/include-css "/css/normalize.css"
                       "/css/foundation.min.css")
   (hpage/include-js "/js/vendor/custom.modernizr.js")))

(defn common 
  "Creates the basic skeleton for working with Foundation Framework"
  [title & content]
  (hpage/html5
   [:head
    [:title title]
    (head-js-css)]
   [:body
    (toplink)
    ;[:h1 title]
    ;[:h1 content]
    (apply container content) ;; de-structure content into one list
    ;; Foundation framework initialization
    (hpage/include-js "/js/init.js")
    (hpage/include-js "/js/foundation.min.js")
    (hpage/include-js "/js/load-plugins.js")
    ]))



