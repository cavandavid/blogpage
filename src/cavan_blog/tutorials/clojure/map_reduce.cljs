(ns cavan-blog.tutorials.clojure.map-reduce)

(def view
  [:div.text-center.mt-4
   [:div.container
    [:div.row.content
     [:div.col-md-12.p-normal.text-start
      [:h4.text-bg-dark.p-4 "Collections Processing"]
      [:h4.bold.mt-4 "1. Map"]
      [:hr]
      [:p.syntax "Syntax"]
      [:div.alert.alert-success.text-start
       [:pre>code.language-clojure
        "(map function-that-takes-1-or-more-args 1-or-more-collections)"]]
      [:p
       "Map function helps you execute a set of commands for each element of a collection. The result is a collection containing the results of the function on each item"]
      [:pre>code.language-clojure

       "user=> (def my-collection `(1 2 3 4 5 6 7 8 9 10))\n#'user/my-collection"]
      [:pre>code.language-clojure  "user=> (map inc my-collection)\n(2 3 4 5 6 7 8 9 10 11)"]
      [:p
       "Remember the syntax for the map function, the function must take as many arguments as the collections given. So the above code snippet can also be written as"]
      [:pre>code.language-clojure

       "user=> (map (fn [x] (inc x)) my-collection)\n(2 3 4 5 6 7 8 9 10 11)"]
      [:pre>code.language-clojure
       "user=> (map #(inc %) my-collection)\n(2 3 4 5 6 7 8 9 10 11)"]
      [:p
       "The Map function returns a lazy sequence. The thing with lazy sequences is that the side effects(things like printing,writing to file systems etc) in them dont get evaluated at definition"]
      [:pre>code.language-clojure

       "user=> (def result (map #(do (println \"Your number is \"%) (inc %)) my-collection))\n#'user/result"]
      [:p "Well... atleast not until the value is requested"]
      [:pre>code.language-clojure

       "user=> result\nYour number is  1\nYour number is  2\nYour number is  3\nYour number is  4\nYour number is  5\nYour number is  6\nYour number is  7\nYour number is  8\nYour number is  9\nYour number is  10\n(2 3 4 5 6 7 8 9 10 11)"]
      [:h4.bold "2. Filter"]
      [:hr]
      [:p.syntax "Syntax"]
      [:div.alert.alert-success
       [:pre>code.language-clojure
        "(filter function collection)"]]
      [:p
       "The filter function is similar to map, wherein it runs a function over each element\nExcept the result is only those items, for which the function returned truthy value"]
      [:pre>code.language-clojure  "user=> (filter even? my-collection)\n(2 4 6 8 10)"]
      [:p.note
       "Note: Like the map function, the filter also returns a lazy sequence"]
      
      [:h4.bold  "3. Reduce"]
      [:hr]
      [:p.syntax "Syntax"]
      [:div.alert.alert-success
       [:pre>code.language-clojure 
        "(reduce fn collection) OR (reduce fn first-arg collection)"]]
      [:p.note "NOTE: The function is a function that accepts two arguments."]
      [:p
       "If the optional first arguement is not given, the function takes the first two members of the collection as args"]
      [:p
       "For the second iteration the result of the function's earlier call and the next item in the collection are passed as arguments to the function\nAnd so on , till we have traversed the last item of the collection."]
      [:pre>code.language-clojure  "user=> (reduce + [1 2 3 4 5])\n15"]
      [:p.note
       "Note: The result of Reduce may or may not be a collection, but the result of map and filter is always a collection"] 
      ]]]]
     
     

     
     )
