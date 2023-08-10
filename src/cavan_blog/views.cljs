(ns cavan-blog.views
  (:require
   [re-frame.core :as re-frame]
   [reagent.core :as r]
   [reitit.frontend.easy :as rfe] 
   [cavan-blog.events :as events]
   [cavan-blog.subs :as subs]
   cavan-blog.tutorials.python.basics
   cavan-blog.tutorials.python.collections
   cavan-blog.tutorials.python.control-flow
   cavan-blog.tutorials.python.errors
   cavan-blog.tutorials.python.exceptions
   cavan-blog.tutorials.python.misc
   cavan-blog.tutorials.clojure.map-reduce
   cavan-blog.tutorials.clojure.redefs
   cavan-blog.tutorials.postgres.create
   cavan-blog.tutorials.postgres.crud
   cavan-blog.tutorials.postgres.joins
   cavan-blog.tutorials.postgres.time
   [clojure.string]))
(defn href
  "Return relative url for given route. Url can be used in HTML links."
  ([k]
   (href k nil nil))
  ([k params]
   (href k params nil))
  ([k params query]
   (rfe/href k params query)))

(defn single-panel [id data]
  (let [content-size (r/atom 0)]
    (fn [id data]
      (let [expansions @(re-frame/subscribe [::subs/expansions])
            active? (get-in expansions [id :flag])]

        [:div.col-sm-3
         [:span {:on-click (fn [e]
                             (re-frame/dispatch-sync [::events/toggle-info id]))}
          [:h5 {:class (if active? "header-active" "header-inactive")}
           (clojure.string/capitalize (str (name id)))

           [:span.expand-button (if (get-in expansions [id :flag]) "-" "+")]]]
         [:div {:style {:overflow :hidden
                        :max-height
                        (if active?
                          (str @content-size "px")
                          0)}}
          [:div.sub-section  {:ref #(when %
                                     (reset! content-size (.-clientHeight %)))}

           (into [:ul ]
                 (for [{name :name link :link} data]
                   [:li 
                    
                    
                    [:a {:href (href link)} name]
                    ]))]]]))))

(defn listing-page [language data]
  (let [generate-badge (fn [language]
                         [:span.badge.rounded-pil.ms-2
                         {:class (case language
                                   :python "bg-primary"
                                   :clojure "bg-danger"
                                   :postgres "bg-success"
                                   :docker "bg-warning")} 
                          language])]
    [:div.listing-page.border-left
     {:class (case language
               :python "border-primary"
               :clojure "border-danger"
               :postgres "border-success"
               :docker "border-warning")}
     (into [:ul.list-group.list-group-flush]
           (mapv (fn [{name :name link :link disable :disable :as item}]
                   [:a {:href (href link)} 
                   [:li.list-group-item.list-group-item-light
                    (if disable
                      [:s name]
                      name)
                    (generate-badge language)]]) data))

     
     
     ]))


 (defn main-panel []
   (let [expansions @(re-frame/subscribe [::subs/expansions])
         navigated  @(re-frame/subscribe [::subs/current-route])]
     [:div.container-fluid.parentMain>div.row
      [:div.col-md-3.col-xs-3
       [:div.parent.text-bg-dark.p-3
        [:div.row.text-center
         [:h2.mt-4 {:style {:color nil}}
          "CAVAN DAVID"]
         [:h6.display-8 "SENIOR SOFTWARE ENGINEER/ TECH LEAD"]]

        [:div.me
         [:a {:href "/"} [:img.img-thumbnail {:src "/images/cav.jpg"}]]]
        [:div.mt-4

         [:blockquote

          [:h3 {:style {:color nil}}
           "About Me"]
          [:p.lead
           "A full stack Software Engineer with around 7 years of experience with expertise in Clojure(script), AWS, Kubernetes, Python and Relational databases"]]
         [:div.content-block
          [:p.remove-bottom-padding [:i.bi.bi-envelope.bootstrap-icon-default]
           [:span.ps-2.mb-0 "cavan.david@yahoo.in"]]
          [:p.remove-bottom-padding [:i.bi.bi-linkedin.bootstrap-icon-default]
           [:span.ps-2.mb-0 [:a {:href "https://www.linkedin.com/in/cavan-david-604222b2/"}
                             "cavan-david"]]]]]]]
      [:div.col-md-9.col-xs-9

       [:div.row.tutorial-container
        [:div.text-center.homepage-title
         [:h2.strong.text-center.mt-3 "Code Made Easy"]
         [:p "The collection of topics here is an effort to help you realize how simple it is to dive into technologies you might have earlier deemed too cryptic, Lets dive in!"]]

        [:div.col-12.tutorial-content.mt-3
         (case (get-in navigated [:data :name])
           ;; PYTHON
           :cavan-blog.routes/python-basics
           cavan-blog.tutorials.python.basics/view
           :cavan-blog.routes/python-collections
           cavan-blog.tutorials.python.collections/view
           :cavan-blog.routes/python-control-flow
           cavan-blog.tutorials.python.control-flow/view
           :cavan-blog.routes/python-errors
           cavan-blog.tutorials.python.errors/view
           :cavan-blog.routes/python-exceptions
           cavan-blog.tutorials.python.exceptions/view
           :cavan-blog.routes/python-misc
           cavan-blog.tutorials.python.misc/view
           ;; CLOJURE
           :cavan-blog.routes/clojure-map-reduce
           cavan-blog.tutorials.clojure.map-reduce/view
           :cavan-blog.routes/clojure-redefs
           cavan-blog.tutorials.clojure.redefs/view
           ;; POSTGRES
           :cavan-blog.routes/postgres-create
           cavan-blog.tutorials.postgres.create/view
           :cavan-blog.routes/postgres-crud
           cavan-blog.tutorials.postgres.crud/view
           :cavan-blog.routes/postgres-joins
           cavan-blog.tutorials.postgres.joins/view
           :cavan-blog.routes/postgres-time
           cavan-blog.tutorials.postgres.time/view

           :cavan-blog.routes/wip
           [:div.alert.alert-warning
            [:h4.alert-heading "Unfortunately, i haven't been able to finish this write up"]
            [:hr]
            [:p "Will try to complete it before the next time you visit this page"]]
           [:span
            [listing-page :python [{:name "The Basics" :link :cavan-blog.routes/python-basics}
                                   {:name "Control Flow" :link :cavan-blog.routes/python-control-flow}
                                   {:name "Collections" :link :cavan-blog.routes/python-collections}
                                   {:name "Exceptions" :link :cavan-blog.routes/python-exceptions}
                                   {:name "Errors" :link :cavan-blog.routes/python-errors}
                                   {:name "Misc.(stuff i found cool)" :link :cavan-blog.routes/python-misc}]]
            [listing-page :clojure [{:name "Collection Processing" :link :cavan-blog.routes/clojure-map-reduce}
                                    {:name "Time Travel ft. (redefs, macros etc)" :link :cavan-blog.routes/clojure-redefs}
                                    {:name "IO Operations (WIP)" :link :cavan-blog.routes/wip :disable true}
                                    {:name "Basic Web app (WIP)" :link :cavan-blog.routes/wip :disable true}]]
            [listing-page :postgres [{:name "Create and access database" :link :cavan-blog.routes/postgres-create}
                                     {:name "CRUD Operations" :link :cavan-blog.routes/postgres-crud}
                                     {:name "Joins" :link :cavan-blog.routes/postgres-joins}
                                     {:name "Play with time" :link :cavan-blog.routes/postgres-time}]]
            [listing-page :docker [{:name "Introduction (WIP)" :link :cavan-blog.routes/wip :disable true}
                                   {:name "Get your hands dirty (WIP)" :link :cavan-blog.routes/wip :disable true}]]])]]]


      ;; [:div.col-md-12.footer.black
      ;;  [:span.email "cavan.david@yahoo.in"]
      ;;  [:span.linkedin
      ;;   [:a {:href "https://www.linkedin.com/in/cavan-david-604222b2/"
      ;;        :target "_blank"} "Linkedin"]]]
      [:nav.navbar.fixed-bottom.navbar-expand-sm.navbar-dark.blue-linear-grad.bg-dark
       [:a.navbar-brand.ps-3 {:href "#"}
        "Made with Clojurescript, retit and love"]
       [:button.navbar-toggler {:type "button"
                                :data-toggle "collapse"
                                :data-target "#navbarCollapse"
                                :aria-controls "navbarCollapse"
                                :aria-expanded "false"
                                :aria-label "Toggle navigation"}
        [:span.navbar-toggler-icon]]
       [:div#navbarCollapse.collapse.navbar-collapse
        [:ul.navbar-nav.mr-auto
         [:li.nav-item.active
          [:a.nav-link {:href "#"}
           "Home"]]


         [:li.nav-item.dropup]]]]]
     ))
