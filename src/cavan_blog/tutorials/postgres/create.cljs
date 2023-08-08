(ns cavan-blog.tutorials.postgres.create)

(def view
 [:div.container.mt-4
  [:div.row
   [:div.col-md-12
    [:div.text-center
     [:h4.text-bg-dark.p-4 "Setting up PSQL"]
     [:p.lead.mt-3 "PSQL is an open source relational database with a great community supporting it. With updates being released regularly and its easy to use nature , PSQL is one of those languages which a developer should have in his utility belt"]
     [:p "With that out of the way, lets begin!"]
     [:p.syntax "Disclaimer: Using Ubuntu for the sake of this tutorial, Steps would most likely be same for other debian based systems"]]
    [:div-text-start
     [:p [:b "INSTALLATION"]
      [:pre>code {:class "language-bash"}
       "sudo apt-get install postgresql"
       ]
      [:p.mt-3 "For the sake of authentication, PSQL has a role-based system which for the most part only allows users with a PSQL role to interact with the database. Luckily for us, during the installation of psql, it creates a user with name 'postgres' and an associated role in PSQL datahase also called 'postgres'"]
      [:p.syntax "Note: The username and role of the PSQL database must match for it to be able to connect to the psql prompt."]
      [:p "But rules were meant to be broken.."]
      [:pre>code {:class "language-bash"}
       "cavan@cavan--E470:~$ id -u -n ;; Check current user
cavan
cavan@cavan--E470:~$ psql
psql: FATAL:  role \"cavan\" does not exist"
       ]
      [:p "Not this one though....."]
      [:p "I couldn't enter through my user acount cavan, because there is no 'cavan' PSQL role setup yet, lets just use the postgres role which is created by default"]
      [:pre>code {:class "language-bash"}
       "cavan@cavan--E470:~$ sudo -i -u postgres ;;change user to postgres on your linux terminal
postgres@cavan--E470:~$ psql
psql (10.6 (Ubuntu 10.6-0ubuntu0.18.04.1))
Type \"help\" for help.

postgres=#"]
      [:p "It is considered bad practice to use the default postgres role for creating project specific databases and its always better to have a role that is dedicated to the project they are a part of, Lets go create a separate role for us"]
      [:pre>code {:class "language-bash"}
       "cavan@cavan--E470:~$ sudo -i -u postgres
postgres@cavan--E470:~$ psql
psql (10.6 (Ubuntu 10.6-0ubuntu0.18.04.1))
Type \"help\" for help.

postgres@cavan--E470:~$ createuser  --no-superuser --pwprompt cavan
Enter password for new role: 
Enter it again:"]
      [:p "And there you have successfully created a matching new role in PSQL, lets try logging in psql directly"]
      [:pre>code {:class "language-bash"}
       "cavan@cavan--E470:~$ psql
psql: FATAL:  database \"cavan\" does not exist"]
      [:p "Wait what? Nothing to worry, PSQL makes an assumption that a db exists with the same name as the username, and complaints if it is not so, so lets just go ahead and create a db"]
      [:pre>code {:class "language-bash"}
       "postgres@cavan--E470:~$ createdb --owner cavan cavan

cavan@cavan--E470:~$ psql
psql (10.6 (Ubuntu 10.6-0ubuntu0.18.04.1))
Type \"help\" for help.

cavan=> "]
      [:p "Here we have successfully created a role and database for our user, Lets just list our databases using "\l" and we should see them there"]
      [:pre>code {:class "language-bash"}
     "cavan=> \\l
                              List of databases
   Name    |  Owner   | Encoding | Collate | Ctype |   Access privileges   
-----------+----------+----------+---------+-------+-----------------------
 cavan     | cavan    | UTF8     | en_IN   | en_IN | 
 postgres  | postgres | UTF8     | en_IN   | en_IN | 
 template0 | postgres | UTF8     | en_IN   | en_IN | =c/postgres          +
           |          |          |         |       | postgres=CTc/postgres"]
[:p "Lets go ahead and create some tables in our databse."]
[:pre>code {:class "language-sql"} "CREATE TABLE people(
	id      SERIAL PRIMARY KEY,
	name 	TEXT UNIQUE NOT NULL,
	house   TEXT NOT NULL
);"]
       [:pre>code {:class "language-sql"} "CREATE TABLE rulers(
	id        SERIAL PRIMARY KEY,
	name      TEXT REFERENCES people(name),
	title     TEXT NOT NULL,
	people_id INT  REFERENCES people(id)
)"]
      [:p 
       "The columns are pretty self explanatory"]

[:p.syntax "{name_of_column} {type_of_data} {attributes}"]

[:p "The primary key ensures that each record of the table is unique and the thing that makes each record unique is the value of the primary key field. The type 'SERIAL' is to let PSQL know that the field is a unique auto incrementing field"]

[:p "We have also used REFERENCES attribute which is to signify the column as a Foreign Key. In simple words the FOREIGN KEY 'people_id' is there to have a link between the two tables and add a layer of checking to ensure data integrity. Data integrity is just a fancy name for ensuring we dont enter false data and we can be sure that the value entered in the column is as per what we expect"]

[:p "In this case, the value in rulers.people_id must be present in people.id table and would complaint otherwise"]
       [:p "That's for the introductory part, Hope you enjoyed the blog!"]
      
      
      
      ]]]] ]
)
 
