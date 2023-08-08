(ns cavan-blog.tutorials.clojure.redefs)

(def view
  [:div.text-center
   [:div.container.mt-4
    [:div.row
     [:h4.text-bg-dark.p-4 "Play with time(using macros) to manipulate function behaviour"]
     [:hr]
     [:h6.mt-4 "We will touch upon redefs, macros(which help you build functionality into the language). So sit tight!"]

     [:div.col-md-12.p-normal.text-start.mt-4
      
      [:p
       
       "I went ahead and created a really basic function birthday-wisher and some data structures to reflect different people, namely "
       [:b "Jim, Jack and James"]]
      [:pre
       [:code.language-clojure.language-clojure
        "(ns tt-blog.core\n  (:require [clj-time.core :as time]\n        [clojure.test :refer [testing is]]))\n\n(defn birthday-wisher\n  \"I wish the person if its his birthday\"\n  [{:keys [name birthday] :as person}]\n  (if (time/equal? \n        (time/today) \n         birthday)\n    (str \"Happy birthday, \" name \"!\")\n    (str \"Its not your birthday, \" name \"!\")))\n\n(def jim\n  \"Jim's birthday is today\"\n  {:name \"Jim\"\n   :birthday (time/today)})\n\n(def jack\n  \"Jack's birthday is one month from now\"\n  {:name \"Jack\"\n   :birthday (time/plus \n               (time/today) \n               (time/months 1))})\n\n(def james\n  \"James' birthday is 2 days from now\"\n  {:name   \"James\"\n   :birthday (time/plus \n               (time/today) \n               (time/days 2))})"]]
      [:p
       "Jim's birthday is today, Jack's birthday is a month from now and James' birthday is 2 days from now."
       [:br]]
      [:p
       "Lets throw in some tests"]
      [:pre
       [:code.language-clojure
        "(testing \"checking integrity of birthday-wisher\"\n  (is (= (birthday-wisher jim) \"Happy birthday, Jim!\")\n    \"Jim should have been wished for his birthday!\")\n  (is (= (birthday-wisher jack) \"Its not your birthday, Jack!\")\n    \"Its not Jack's birthday!\")\n  (is (= (birthday-wisher james) \"Its not your birthday, James!\")\n    \"Its not James' birthday!\"))"]]
      [:p
       "These tests work as they should, but aren't as exhaustive as i would like."]
      [:p
       "What if i want to ensure that 2 days from now, James too would be wished for his birthday"]
      [:p
       "The birthday function relies on clj-time.core/now to get the current time.\n  We can redefine this function so that it it evaluates to a date of 2 days from now to see if james is wished on his birthday"]
      [:pre
       [:code.language-clojure
        "(testing \"checking integrity of birthday-wisher \"\n  (let [today-date (time/today)]\n    (is (= (with-redefs \n           [time/today (fn []\n                         (time/plus \n                           today-date \n                           (time/months 1)))] \n         (birthday-wisher jack)) \"Happy birthday, Jack!\")\n  \"Jack should be wished 1 month from now\")\n\n  (is (= (with-redefs \n        [time/today (fn [] \n                      (time/plus\n                        today-date\n                        (time/days 2)))] \n        (birthday-wisher james)) \"Happy birthday, James!\")\n  \"James should be wished 2 days from now\")))"]]
      [:p "The tests works as expected"]
      [:p
       "Now using with-redefs each time i want to test is getting a little repetitive"]
      [:p
       "Creating a utility macro that i can call each time i want to time-travel and execute body in the new context seems like the right thing to do.. Let's do it!"]
      [:pre
       [:code.language-clojure
        "(defmacro with-time-travel\n  [time-operator duration & body]\n  `(let [operator# (case ~time-operator\n                        \"+\"  clj-time.core/plus\n                        \"-\"  clj-time.core/minus)\n         now-time#  (clj-time.core/today)]\n    (with-redefs [clj-time.core/today  \n      (fn [& _#]\n        (operator# now-time# ~duration))] ~@body)))"]]
      [:p "Let's test it out, shall we?"]
      [:pre
       [:code.language-clojure
        "tt-blog.core=> (time/today)\n#object[org.joda.time.LocalDate 0x603174ab \"2019-03-17\"]\ntt-blog.core=> jack\n{:name \"Jack\", :birthday #object[org.joda.time.LocalDate 0x6c1a37e9 \"2019-04-17\"]}\ntt-blog.core=> (with-time-travel \"+\" (time/months 1) (birthday-wisher jack))\n\"Happy birthday, Jack!\""]]
      [:p "It works!!"]]]]])
