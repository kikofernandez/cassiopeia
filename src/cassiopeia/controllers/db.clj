(ns cassiopeia.controllers.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            ))

(def latest 5)

(def connect
;  (mg/connect-via-uri! "mongodb://admin:17SkMHIsKB2k@localhost:27017/janina")
  (mg/connect-via-uri! "mongodb://admin:17SkMHIsKB2k@ds057857.mongolab.com:57857/janina"))

(defn login-user
  [email password]
  (mc/find-maps "users" {:email email :password password}))

;(def disconnect
;  (mg/disconnect!))

;(defn db-do [& operations]
;  connect
;  (do operations)
;  disconnect)