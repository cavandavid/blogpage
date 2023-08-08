(ns cavan-blog.tutorials.python.exceptions)
(def view
  [:div.text-center
   [:div.container
    [:div.row.heading [:img.python-heading-images.center-img {:src "/images/exceptions.png"}]]
    [:div.row
     [:p.text-center.tutorial-intro
      "Exceptions are ways to alter the normal control flow of the program. It includes"
      [:b " Raising Exceptions"]
      " &"
      [:b " Handling Exceptions"]]]

    [:p.text-center [:b "1.Raising Exceptions"] [:br]]
    [:div.text-center.innercontent
     "Let's Consider a simple program that prints out the square of a number"
     [:div.row.innercontent.text-center.codecontent
      [:div.col-md-12

       [:pre>code.language-python
        "def our_doubler(input):\r\n    input=int(input)\r\n    print (input*2)\r\n\r\nour_doubler(3)
>>Output
6"]]]]
    [:p.text-center.innercontent
     "This works as we have control of what is passed to"
     [:i "our_doubler"]
     "function, but real world problems are complex and in most cases our input is going to depend on our end user. What if a non integer is passed to our function?"]
    [:div.row.innercontent.text-center.codecontent
     [:div.col-md-12

      [:pre>code.language-python
       "def our_doubler(input):\r\n    input=int(input)\r\n    print (input*2)\r\n\r\nour_doubler('codebreaker')
>>Output
ValueError: invalid literal for int() with base 10: 'codebreaker'"]
      [:p "The int() function isn't capable of converting our input 'codebreaker' due to which it throws an error and our program crashes. Here's where exception handling comes in handy."]
      [:pre>code.language-python
       "def our_doubler(input):
    if type(input) is not int:
        raise ValueError
    input=int(input)
    print (input*2)

our_doubler('codebreaker')

>>Output
File \"C:/Users/Cavan/PycharmProjects/blog/testing.py\", line 3, in our_doubler
    raise ValueError
ValueError"]
      [:p "As you can see our program still crashes, because just raising an exception is not enough, we need to handle them as well, which brings us to the next section."]
      ]]
    [:hr]
    [:div.row.innercontent.text-center.codecontent
     [:div.col-md-12
      [:b "2. Handling Exceptions"] [:br]
      [:p "Exception Handling is resuming the control flow of the program by redirecting flow to some other block incase of error. The above code snipper can be rewritten as"]
      [:pre>code.language-python
       "def our_doubler(input):
    try:
        if type(input) is not int:
            raise ValueError
        input=int(input)
        print (input*2)
    except ValueError:
        print (\"Our function accepts numbers only!\")
our_doubler('codebreaker')

>>Output
Our function accepts numbers only!"
       ]
      [:p "Now rather our program crashing on receiving a non integer value, we have succesfully handled it and displayed a meaningful message to the end user."]
      [:p [:b "NOTE:"] "Python allows us to catch most of its exceptions , however not all exceptions are needed to be caught and sometimes it is better to stop the program in such cases rather than to continue with inconsistent and incorrect data."]
      ]
     
     ]]
    
        ])
