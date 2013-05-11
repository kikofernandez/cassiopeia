(defproject cassiopeia  "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [ring/ring-json "0.2.0"]
                 ;[cheshire "5.1.1"]
                 [hiccup "1.0.2"]
                 ;[com.novemberain/monger "1.4.2"]
                 [com.novemberain/monger "1.4.2"]
                 ;[cheshire "5.0.2"]
                 [sandbar/sandbar "0.4.0-SNAPSHOT"]
                 ]
  :immutant {:context-path "/"}
  :plugins [[codox "0.6.4"]])
