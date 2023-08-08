(ns cavan-blog.tutorials.postgres.crud)
(def view
  [:div.container.mt-4
  [:div.row
   [:div.col-md-12
    [:div.text-center
     [:h4.text-bg-dark.p-4 "CRUD Operations"]
     [:p.lead.mt-3 "CRUD operations form the heart of all PSQL operations as your webapp will be doing a lot of these to give a seemless experience to the user. If you didn't already know it stands for : Create, Read, Update and Delete"]]
    [:div.text-start
     [:p "We continue with the people and rulers tables we created in the last blog"]
     [:p "Now i've noticed some blogs using tv show references which to be honest comes off as a bit unprofessional, so for the sake of this blog, lets keep it formal..."]
     [:b "1. INSERT"]
     [:p "Insert is pretty straight forward in PSQL"]
     [:p.syntax "1. Insert a record specifying the column names"]
     [:pre>code.language-sql "INSERT INTO people(name,house) VALUES ('Ned', 'Stark');"]
     [:p.syntax "2. Insert a record without giving column name ."
      [:br]
      "NOTE: You need to make sure the order is maintained according to the columns of the table"]
     [:pre>code.language-sql "INSERT INTO people VALUES (2, 'Robert', 'Baratheon');"]
     [:p.syntax "3. You can also insert multiple rows at a time."]
     [:pre>code.language-sql "INSERT INTO people VALUES (3, 'Jon', 'Snow'), (4, 'Jamie', 'Lannister'), (5, 'Theon', 'Greyjoy');"]
     [:hr]
     [:b "2. UPDATE"]
     [:p "As the real world is changing, we will often need to change values we once entered. That's where the UPDATE statement comes in handy"]
     [:p.syntax "Later on Jon realizes he's no snow, but of royal lineage. lets update our table aswell"]
     [:pre>code.language-sql "UPDATE people SET house = 'Targaryen' where name = 'Jon';"]
     [:p.syntax [:b "NOTE:"]
      " If you dont specify the where clause, UPDATE statement will set the value for all the records"]
     [:p "PSQL has a bunch of string functions to play with, lets try out the concat function"]
     [:p.syntax "Find more information on string functions on https://www.postgresql.org/docs/9.1/functions-string.html"]
     [:pre>code.language-sql "UPDATE people SET house = 'House ' || house;

cavan=> select * from people;
 id |  name  |      house      
----+--------+-----------------
  1 | Ned    | House Stark
  2 | Robert | House Baratheon
  4 | Jamie  | House Lannister
  5 | Theon  | House Greyjoy
  3 | Jon    | House Targaryen
(5 rows)"]
     [:hr]
     [:b "3. DELETE"]
     [:p "The syntax for DELETE statement goes 'DELETE FROM table where condition"]
     [:pre>code.language-sql "cavan=> DELETE FROM people where name = 'Theon';
;; Deleted the earlier entry for Theon, since no one likes him
cavan=> select * from people;
 id |  name  |      house      | age 
----+--------+-----------------+-----
  1 | Ned    | House Stark     |  18
  2 | Robert | House Baratheon |  18
  4 | Jamie  | House Lannister |  18
  3 | Jon    | House Targaryen |  18
(4 rows)"]
     [:p.syntax "NOTE: If you don't specify the where clause, Delete statement will do away with all the records
which will then lead to you having to find another job which is out of scope of this tutorial"]
     [:hr]
     [:b "4. ALTER"]
     [:p "PSQL also allows you to alter the structure of tables that have been created with the ALTER statement"]
     [:p "The ALTER statement syntax is ALTER TABLE {table_name} {settings}. Lets add a column of age to our people table"]
     [:pre>code.language-sql
      "cavan=> ALTER TABLE people ADD COLUMN age INT DEFAULT 18;
cavan=> select * from people;
 id |  name  |      house      | age 
----+--------+-----------------+-----
  1 | Ned    | House Stark     |  18
  2 | Robert | House Baratheon |  18
  4 | Jamie  | House Lannister |  18
  3 | Jon    | House Targaryen |  18
(4 rows)
;; Actually we're better of without the age
cavan=> ALTER TABLE people DROP COLUMN age;
cavan=> select * from people ;
 id |  name  |      house      
----+--------+-----------------
  1 | Ned    | House Stark
  2 | Robert | House Baratheon
  4 | Jamie  | House Lannister
  3 | Jon    | House Targaryen
(4 rows)
"]
     [:p "And that's how easy it is , Hope the blog was useful!"]
     
     ]]]])
