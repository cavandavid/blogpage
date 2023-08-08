(ns cavan-blog.tutorials.python.control-flow)

(def view
  [:div.container
   [:img.python-heading-images.center-img {:src "/images/controlflow.png"}]
   [:div.row.text-center.tutorial-intro
    [:p
     "As we have seen uptil now, basic programs comprised of a series of statements which were executed faithfully from top to down by the python interpreter, but what if we wanted to change the flow of the program to make things more dynamic."
     [:br]
     "For eg, the program should be able to analyse the input and accordingly produce an apt output.We have the ability to alter  control flow of the program with certain built-in control flow statements. They are "
     [:b "if, for, while, break and continue statements"]]]

   [:div.row.text-start
    [:div.col-md-12
     [:p [:b "1. if statement"] [:br]
      "The if statement checks for a condition and only if the condition is met, the following code block is executed. Behind the scenes, the condition is converted to a boolean value( True of False). If it evaluates to True then the code block is executed."]
     [:pre>code.language-python [:i "if condition:\r\n    Execute code block"]]]]
   [:div.row.text-start
    [:div.col-md-12
     [:p [:b "2. for statement"] [:br]
      "The for loop executes a given set of statements for each item in a iterable series(lists,tuples etc.). The for loop in python is very similar to the foreach statement in javascript."]
     [:pre>code.language-python
      "for item in iterable_series:
    execute statements"]
     [:p "Before we can see an example of for loop, i'd like to introduct the concept of range. Range is a collection type which is nothing but a progression of integers."]
     [:pre>code.language-python
      "for item in range(0,10):
    print item

>>Output
0
1
2
3
4
5
6
7
8
9"]
     [:p [:b "Note: "] [:br]
      "The ending limit of the range isn't a part of the range."]
     [:p "Now for a real world problem, lets create a function that prints out the square of a all numbers till a specified limit"]
     [:pre>code.language-python "def oursquarer(limit):
    for i in range(1,limit+1):
        print (i**2)

oursquarer(10)

Output
1
4
9
16
25
36
49
64
81
100"]]]
   [:div.row.text-start
    [:div.col-md-12
     [:p [:b "3. while statement"] [:br]
      "The while loop will repeatedly execute a given block of statements as long as the specified condition is being met.Caution: Until we reach a point where our condition is no longer getting satisfied, our program will keep executing until our computer runs out of memory."]
     [:pre>code.language-python
      "while condition_evaluates_to_true:
    execute statements"]
     [:p "Let us solve a real world problem to find the sum of all numbers upto a specified limit , to further solidify our understanding of while loops."]
     [:pre>code.language-python
      "def sum_of_first_n_numbers(num):
    ctr=1
    sum=0
    while ctr<=num:
        sum+=ctr
        ctr+=1
    print (\"The sum of first \"+ str(num) +\" numbers is \"+str(sum))

sum_of_first_n_numbers(6)

>>Output
The sum of first 6 numbers is 21  "]]]
   [:div.row.text-start
    [:div.col-md-12
     [:p [:b "4. break statement"] [:br]
      "The break statement is used when we want to break out of a loop that is currently being executed. In case of nested loops, we exit out of the innermost loop."]
     [:pre>code.language-python
      "solar_system=['Earth','Neptune','Jupiter','Pluto','Venus','Saturn','Uranus','Mercury','Mars']

for planet in solar_system:
    if planet is 'Pluto':
        print(\"Sorry Pluto, you cant hang out with us anymore\")
        break
    print (\"Welcome to the club, \"+planet)

>>Output
Welcome to the club, Earth
Welcome to the club, Neptune
Welcome to the club, Jupiter
Sorry Pluto, you cant hang out with us anymore  "]
     [:p [:b "Note:"]
      [:span " On reaching Venus, it breaks out of the for loop and does not execute the remaining items from the iterable series. What if we just wanted to ignore Venus and continue with execution rather than breaking out of the loop. This is where"]
      [:b "continue"] [:span " statement comes in handy"]]]]
   [:div.row.text-start
    [:div.col-md-12
     [:p [:b "5. continue statement"] [:br]
      "Unlike the break statement, the continue statement will ignore the remainder of the code block for that particular item and will continue with normal execution from the next item of the iterable series."
      [:br]
      "Our Solar system program can be rewritten as"]
     [:pre>code.language-python
      "solar_system=['Earth','Neptune','Jupiter','Pluto','Venus','Saturn','Uranus','Mercury','Mars']

for planet in solar_system:
    if planet is 'Pluto':
        print(\"Sorry Pluto, you cant hang out with us anymore\")
        continue
    print (\"Welcome to the club, \"+planet)

>>Output
Welcome to the club, Earth
Welcome to the club, Neptune
Welcome to the club, Jupiter
Sorry Pluto, you cant hang out with us anymore
Welcome to the club, Venus
Welcome to the club, Saturn
Welcome to the club, Uranus
Welcome to the club, Mercury
Welcome to the club, Mars"]]]])
