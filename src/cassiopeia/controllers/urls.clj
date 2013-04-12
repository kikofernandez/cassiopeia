(ns cassiopeia.controllers.urls)

;; url paths, this way they can be re-used without re-coding

;; These are atoms
(def welcome "/welcome")
(def home "/home")
(def category "/category")
(def documents "/documents")
(def questionnaire "/questionnaire")
(def new "/new")
(def user "/user")
(def home "/home")
(def login "/login")
(def features "/features")
(def waitinglist "/waiting-list")

;; These are compositions
(def questionnaire-new (str questionnaire new))
(def user-welcome (str user welcome))
(def user-category (str user category))
(def user-questionnaire (str user questionnaire))
(def user-documents (str user documents))