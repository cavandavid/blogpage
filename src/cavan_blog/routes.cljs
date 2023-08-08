(ns cavan-blog.routes
  (:require
   
   [cavan-blog.events :as events]
   [re-frame.core :as re-frame]
   [reitit.core :as r]
   [reitit.coercion.spec :as rss]
   [reitit.frontend :as rf]))

(def routes
  ["/"
   [""
    {:name      ::home
     :link-text "Home"}]
   ;; PYTHON
   ["python-basics"
    {:name      ::python-basics
    ;;  :view      sub-page1
     }]
   ["python-collections"
    {:name      ::python-collections
    ;;  :view      sub-page1
     }]
   ["python-control-flow"
    {:name      ::python-control-flow
    ;;  :view      sub-page1
     }]
   ["python-exceptions"
    {:name      ::python-exceptions}]

   ["python-errors"
    {:name      ::python-errors}]

   ["python-misc"
    {:name      ::python-misc}]
   ;; CLOJURE
   ["clojure-map-reduce"
    {:name      ::clojure-map-reduce}]
   ["clojure-redefs"
    {:name      ::clojure-redefs}]
   ;; POSTGRES
   ["postgres-create"
    {:name      ::postgres-create}]
   ["postgres-crud"
    {:name      ::postgres-crud}]
   ["postgres-joins"
    {:name      ::postgres-joins}]
   ["postgres-time"
    {:name      ::postgres-time}]
   ["wip"
    {:name      ::wip}]
   
   
   ["sub-page2"
    {:name      ::sub-page2}]])
(def router
  (rf/router
    routes
    {:data {:coercion rss/coercion}}))



(defn on-navigate [new-match]
  (when new-match
    (re-frame/dispatch [::events/navigated new-match])))
