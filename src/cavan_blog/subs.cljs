(ns cavan-blog.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::expansions
 (fn [db]
   (:expansions db)))


(re-frame/reg-sub
 ::current-route
 (fn [db]
   (:current-route db)))
