(ns cavan-blog.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   
   [reitit.frontend.easy :as rfe] 
   [cavan-blog.events :as events]
   [cavan-blog.views :as views]
   [cavan-blog.config :as config]
   [cavan-blog.routes :as routes]
  
   ))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn init-routes! []
  (js/console.log "initializing routes")
  (rfe/start!
    routes/router
    routes/on-navigate
    {:use-fragment true}))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel {:router routes/router}] root-el)))

(defn init []
  (re-frame/clear-subscription-cache!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (init-routes!)
  (mount-root)
  (js/Prism.highlightAll) 
  (.addEventListener js/document
                     "DOMContentLoaded"
                     #(js/Prism.highlightAll))
  
  (js/setTimeout #(js/Prism.highlightAll) 200)

  )
