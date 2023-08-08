(ns cavan-blog.tutorials.postgres.joins)
(def view
  [:div.container.mt-4
  [:div.row
   [:div.col-md-12
    [:div.text-center
     [:h4.text-bg-dark.p-4 "JOIN OPERATIONS"]
     [:p.lead "Joins are just ways SQL gives you to look at data from different tables in a single combined format. As the name suggests, it literally joins two tables for viewing purposes"]]
    [:div.text-left
     [:p "I went ahead and populated our people and rulers tables"]
     [:pre>code.language-sql
      "cavan=> select * from rulers;
 id |   name   |       title       | people_id 
----+----------+-------------------+-----------
  1 | Robert   | King of Westeros  |         2
  2 | Joffrey  | King of Westeros  |         6
  3 | Jon      | King of the north |         3
  4 | Daenerys | Queen of Dragons  |         8
(4 rows)"]
     [:pre>code.language-sql
      "cavan=> select * from people;
 id |   name   |   house   
----+----------+-----------
  1 | Ned      | Stark
  2 | Robert   | Baratheon
  3 | Jon      | Snow
  4 | Jamie    | Lannister
  5 | Theon    | Greyjoy
  6 | Joffrey  | Baratheon
  7 | Cersei   | Baratheon
  8 | Daenerys | Targaryen
(8 rows)"]
     [:p "To begin with, let's go over some of the more common joins"]
     [:b "1. LEFT JOIN"]
     [:p "Left join basically says consider all records on the left table and only those records from the right table for which the JOIN condition matches"]
     [:pre>code.language-sql "cavan=> select * from rulers left join people on rulers.people_id = people.id;
 id |   name   |       title       | people_id | id |   name   |   house   
----+----------+-------------------+-----------+----+----------+-----------
  1 | Robert   | King of Westeros  |         2 |  2 | Robert   | Baratheon
  2 | Joffrey  | King of Westeros  |         6 |  6 | Joffrey  | Baratheon
  3 | Jon      | King of the north |         3 |  3 | Jon      | Snow
  4 | Daenerys | Queen of Dragons  |         8 |  8 | Daenerys | Targaryen
(4 rows)"]
     [:hr]
     [:b "2. RIGHT JOIN"]
     [:p "Right join basically says consider all records on the right table and only those records from the left table for which the JOIN condition matches"]
     [:pre>code.language-sql "cavan=> select * from rulers right join people on rulers.people_id = people.id;
 id |   name   |       title       | people_id | id |   name   |   house   
----+----------+-------------------+-----------+----+----------+-----------
  1 | Robert   | King of Westeros  |         2 |  2 | Robert   | Baratheon
  2 | Joffrey  | King of Westeros  |         6 |  6 | Joffrey  | Baratheon
  3 | Jon      | King of the north |         3 |  3 | Jon      | Snow
  4 | Daenerys | Queen of Dragons  |         8 |  8 | Daenerys | Targaryen
    |          |                   |           |  5 | Theon    | Greyjoy
    |          |                   |           |  4 | Jamie    | Lannister
    |          |                   |           |  1 | Ned      | Stark
    |          |                   |           |  7 | Cersei   | Baratheon"]
     [:hr]
     [:b "3. INNER JOIN"]
     [:p "Inner join consider only records from both the tables for which the condition matches"]
     [:pre>code.language-sql "cavan=> select * from people inner join rulers on people.name = rulers.name;
 id |   name   |   house   | id |   name   |       title       | people_id 
----+----------+-----------+----+----------+-------------------+-----------
  2 | Robert   | Baratheon |  1 | Robert   | King of Westeros  |         2
  6 | Joffrey  | Baratheon |  2 | Joffrey  | King of Westeros  |         6
  3 | Jon      | Snow      |  3 | Jon      | King of the north |         3
  8 | Daenerys | Targaryen |  4 | Daenerys | Queen of Dragons  |         8
(4 rows)"]
     [:p "There are more types of joins in PSQL, but with the understanding of the above three joins you should be in pretty good place as far as joins are concerned"]
     
     
     
     ]]]])
  
