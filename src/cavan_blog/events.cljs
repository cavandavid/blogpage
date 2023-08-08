(ns cavan-blog.events
  (:require
   [re-frame.core :as re-frame]
   [reitit.frontend.controllers :as rfc]
   [cavan-blog.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::toggle-info
 (fn [db [_ item]]
   (update-in db [:expansions item :flag] not)))

(re-frame/reg-event-db
 ::update-height
 (fn [db [_ item height]]
   (assoc-in db [:expansions item :height] height)))

(re-frame/reg-event-db ::navigated
  (fn [db [_ new-match]]
    (js/console.log "|||" new-match)
    (let [old-match   (:current-route db)
          controllers (rfc/apply-controllers (:controllers old-match) new-match)]
      (assoc db :current-route (assoc new-match :controllers controllers)))))
