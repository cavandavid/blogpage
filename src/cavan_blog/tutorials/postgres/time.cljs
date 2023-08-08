(ns cavan-blog.tutorials.postgres.time)
(def view
  [:div.container.mt-4
  [:div.row
   [:div.col-md-12
    [:div.text-center
     [:h4.text-bg-dark.p-4 "Timestamps and Date in Postgres"]
     [:p.lead "For playing around with time, PSQL has some pretty cool functions associated with it. I encourage you to spend some time on Documentation on datetime functions"]]
    [:div.text-left.mt-4
     [:p "Lets see the now() function which is generally used to keep track of things that are important to our business"]
     [:p "For eg. a business might benefit from knowing when a new record was added in its customer table"]
     [:pre>code.language-sql "cavan=> select now();
               now                
----------------------------------
 2019-03-09 20:01:45.057583+05:30
(1 row)"]
     [:p "If the part in front of the date looks weird, don't worry its the timestamp part. The type is called timestamp with timezone"]
     [:pre>code.language-sql "cavan=> select pg_typeof(now());
        pg_typeof         
--------------------------
 timestamp with time zone
(1 row)"]
     [:p "If the timestamp part is not relevant to you, you can use type cast to convert the value to a simpler data type like date"]
     [:pre>code.language-sql "cavan=> select pg_typeof(now()::date);
 pg_typeof 
-----------
 date
(1 row)"]
     [:hr]
     [:p.lead.text-center "Lets solidify our learning with an example"]
     [:p.syntax "Lets create a birthdays table"]
     [:pre>code.language-sql "CREATE TABLE birthdays(id SERIAL PRIMARY KEY, people_name TEXT REFERENCES people(name), birthday timestamp DEFAULT now());"]
     [:p.syntax "Note: SERIAL type is used to signify its an auto incrementing integer"]
     [:pre>code.language-sql "INSERT INTO birthdays(people_name,birthday) VALUES('Ned', '1959-4-17');"]
     [:p.text-center.syntax "While making this i vowed to be as accurate as possible so.."]
     [:img.img-thumbnail {:src "/images/seanbean1.png"}]
     [:p "I went ahead and populated some more values for our birthdays table"]
     [:pre>code.language-sql
      "cavan=> select * from birthdays;

 id | people_name |      birthday       
----+-------------+---------------------
  3 | Ned         | 1959-04-17 00:00:00
  4 | Ned         | 1959-04-17 00:00:00
  5 | Robert      | 1958-01-01 00:00:00
  6 | Jon         | 1986-12-26 00:00:00
  7 | Jamie       | 1970-07-27 00:00:00
  8 | Theon       | 1989-01-02 00:00:00
  9 | Joffrey     | 1994-01-01 00:00:00
 10 | Cersei      | 1973-01-01 00:00:00
 11 | Daenerys    | 1985-07-27 00:00:00
 12 | Arya        | 1998-01-02 00:00:00
 13 | Sansa       | 1993-01-01 00:00:00
 14 | Bran        | 1999-01-01 00:00:00
(12 rows)"]
     [:p "Notice the birthdays is a timestamp value, and since we provided only dates, there is an implicit conversion that takes place from dates to timestamp value."]
     [:p.syntax "Now that we have some data, lets have some fun"]
     [:hr]
     [:b "1. TYPE CASTS"]
     [:p "Say i want to see simple dates instead of timestamps, i'l go ahead and use type casting (::)"]
     [:pre>code.language-sql "cavan=> select birthday::date from birthdays;
  birthday  
------------
 1959-04-17
 1959-04-17
 1958-01-01
 1986-12-26
 1970-07-27
 1989-01-02
 1994-01-01
 1973-01-01
 1985-07-27
 1998-01-02
 1993-01-01
 1999-01-01
(12 rows)"]
     [:p "The cast type is pretty cool right, but you can only cast to compatible values."]
     [:p "Say i hit my head really hard on my way to the office, and i want to cast timestamps to integers"]
     [:pre>code.language-sql "cavan=> select birthday::int from birthdays;
        ERROR:  cannot cast type timestamp without time zone to integer"]
     [:p "Yeah doesn't work"]
     [:hr]
     [:b "2. DATE_TRUNC"]
     [:p "Another cool function we have with dates is DATETRUNC. As the name suggests it ignores values beyond the specified precision level."]
     [:p "For eg. say i only care about birthday years"]
     [:pre>code.language-sql "cavan=> select people_name,DATE_TRUNC('year',birthday) from birthdays;
 people_name |     date_trunc      
-------------+---------------------
 Ned         | 1959-01-01 00:00:00
 Ned         | 1959-01-01 00:00:00
 Robert      | 1958-01-01 00:00:00
 Jon         | 1986-01-01 00:00:00
 Jamie       | 1970-01-01 00:00:00
 Theon       | 1989-01-01 00:00:00
 Joffrey     | 1994-01-01 00:00:00
 Cersei      | 1973-01-01 00:00:00
 Daenerys    | 1985-01-01 00:00:00
 Arya        | 1998-01-01 00:00:00
 Sansa       | 1993-01-01 00:00:00
 Bran        | 1999-01-01 00:00:00
(12 rows)"]
     [:p "As seen it conveniently ignores the information about the date up until the specified parameter(In this case year)"]
     [:hr]
     [:b "3. EXTRACT"]
     [:p "The extract function allows you to extract individual parts of a timestamp or interval"]
     [:pre>code.language-sql
      "cavan=> select people_name,EXTRACT(year from birthday) from birthdays;
 people_name | date_part 
-------------+-----------
 Ned         |      1959
 Ned         |      1959
 Robert      |      1958
 Jon         |      1986
 Jamie       |      1970
 Theon       |      1989
 Joffrey     |      1994
 Cersei      |      1973
 Daenerys    |      1985
 Arya        |      1998
 Sansa       |      1993
 Bran        |      1999
(12 rows)"]
     [:p "Seems okay right? But it's a real power tool to have in your PSQL utility belt."]
     [:p "Say you came upon a really cool joke on the internet but unfortunately as luck would have it, only 90's kids could relate to it."]
     [:p "So how do you extract only those people that were born in the 90's?"]
     [:pre>code.language-sql "cavan=> select * from birthdays where EXTRACT(decade from birthday) = 199;
 id | people_name |      birthday       
----+-------------+---------------------
  9 | Joffrey     | 1994-01-01 00:00:00
 12 | Arya        | 1998-01-02 00:00:00
 13 | Sansa       | 1993-01-01 00:00:00
 14 | Bran        | 1999-01-01 00:00:00
(4 rows)"]
     [:p "There our secret is safe.."]
     [:br]
     [:p "The journey doesn't end here, I'd encourage you to go through "
      [:a {:href "https://www.postgresql.org/docs/8.4/functions-datetime.html"}
       "Documentation of datetime functions"]]
     ]]]])
