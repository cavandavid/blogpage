(ns cavan-blog.core
  (:require
   [reagent.dom :as rdom]
   [reagent.core :as reagent]
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
;; Retit routing related




;; (defn nav [{:keys [router current-route]}]
;;   [:ul
;;    (for [route-name (r/route-names router)
;;          :let       [route (r/match-by-name router route-name)
;;                      text (-> route :data :link-text)]]
;;      [:li {:key route-name}
;;       (when (= route-name (-> current-route :data :name))
;;         "> ")
;;       ;; Create a normal links that user can click
;;       [:a {:href (href route-name)} (str text "| " route-name "  | "(href route-name) )]])])

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
  (mount-root))
