(defproject cassiopeia  "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [ring/ring-json "0.2.0"]
                 [hiccup "1.0.2"]
                 [com.novemberain/monger "1.4.2"]
                 [cheshire "5.0.2"]
                 ]
  :immutant {:context-path "/"}
  :plugins [[codox "0.6.4"]])
