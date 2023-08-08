(ns cavan-blog.tutorials.python.errors)
(def view
  [:div.container
   [:div.row>div.col-md-12

    [:div [:img.python-heading-images.center-img {:src "images/errors.png"}]]
    [:p.tutorial-intro
     "Errors detected during execution are called as Exceptions. All StandardError's originate from class Exception which in turn inherits from class BaseException. There are plenty of errors in Python, in this module we will go through some of the more common ones."]]
   [:div.row
    [:div.col-md-6
     [:b "1. ValueError"]
     [:p "This error occurs when a function receives an argument that is of correct type but is of incompatible value to a function."]]
    [:div.col-md-6
     [:pre>code.language-python
      "print(int(\"99\"))
>>99
print(int(\"im here to break your code :)\"))
>>ValueError: invalid literal for int() with base 10: 'im here to break your code :)"]]]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "2. TypeError"]
     [:p "This error occurs when a function receives an object of incorrect type i.e incompatible to the function."]]
    [:div.col-md-6
     [:pre>code.language-python
      "print(int([1,2,3,4,5]))
>> TypeError: int() argument must be a string, a bytes-like object or a number, not 'list'  "]]]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "3. IndentationError"]
     [:p "This error occurs when we have inconsistency in the indentation of our code."]]
    [:div.col-md-6
     [:pre>code.language-python
      "def do_something():
    try:
        print(\"Hello\")
    except:

do_something()

>>    do_something()
    ^
IndentationError: expected an indented block"]
     [:p "Here have left our except block empty. It is not allowed to have empty blocks, use pass instead which literally does nothing and is just used as a filler. The above code snippet can be rewritten as"]
     [:pre>code.language-python
      "def do_something():
    try:
        print(\"Hello\")
    except:
        pass

do_something()
>> Hello  "]
     
     ]]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "4. NameError"]
     [:p "This error occurs when we call a function or a variable before it has been defined. for eg."]]
    [:div.col-md-6
     [:pre>code.language-python
      "print (displaymessage())

def displaymessage():
	return 'Welcome, good sir'

>>NameError: name 'displaymessage' is not defined"]
     [:p "Here we have called displaymessage before defining it"]]]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "5. SyntaxError"]
     [:p "This error is commonly seen amongst new Python developers , so if you see it don’t freak out. It occurs when our code is not syntactically correct"]]
    [:div.col-md-6
     [:pre>code.language-python "while True
    print('Check your syntax')

>>while True
             ^
SyntaxError: invalid syntax"]
     [:p [:b "NOTE:"] "The missing colon in front of the while condition"]]
    ]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "6. IndexError"]
     [:p "This error occurs when we try to access an indexed element from an iterable series like strings, lists etc which doesn’t exist or is out of bounds."]]
    [:div.col-md-6
     [:pre>code.language-python "my_list=[1,2,3,4,5]
print (my_list[10])

>>print (my_list[10])
IndexError: list index out of range"]
     [:p  "Here We are trying to access the 10th element from a list that has only 5 elements."]]
    ]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "7. KeyError"]
     [:p "This error occurs when we the compiler is unable to find the specified key in the dictionary."]]
    [:div.col-md-6
     [:pre>code.language-python "my_dict={'Jon':'Targaryen','Sansa':'Stark','Arya':'Stark'}
print (my_dict['Ramsey'])

>>print (my_dict['Ramsey'])
KeyError: 'Ramsey'"]
     [:p  "Here We are trying to access the key 'Ramsey' which is not present in the dictionary."]]
    ]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "8. ImportError"]
     [:p "This error occurs when we the compiler is unable to find the module we are trying to import in our program.This can be due to a spelling error or the module has not been installed on your system."]]
    [:div.col-md-6
     [:pre>code.language-python "import teme

>>import teme
ModuleNotFoundError: No module named 'teme'
"]
     [:p  "Perhaps a drunk man trying to type the module time"]]
    ]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "9. ZeroDivisionError"]
     [:p "This error occurs when we try to divide by 0."]]
    [:div.col-md-6
     [:pre>code.language-python "def our_divider(num):
    return 100/num

print (our_divider(0))

>>    return 100/num
ZeroDivisionError: division by zero"]
     [:p  "It is better to catch this as if we succeed in our division by zero we will end up tearing a hole in time and space."]]
    ]
   [:hr]
   [:div.row
    [:div.col-md-6
     [:b "10. NotImplementedError"]
     [:p "Remember abstract methods from our days in Java? Well in old school Python before the days of abc module, definining abstract methods was a bit lengthy."]]
    [:div.col-md-6
     [:pre>code.language-python "class animal():
    def talk(self):
            print ('Hello good sir, im an animal')
class dog(animal):                 #class dog is inheriting from class animal
	def talk(self):
		print ('Wuff wuff!')

d=dog()
d.talk()

>> Wuff wuff!"]
     [:p  "In the above example, we have initialized class dog, however nothing is stopping us from initializing parent class animal and calling its talk method, which breaks the fundamental concept of an abstract class. Since as we know abstract classes cannot be initialized and abstract methods should generally get their definition from the child class. In this case our NotImplementedError comes in handy, rewriting above code as."]
     [:pre>code.language-python
      "class animal():
    def talk(self):
        raise NotImplementedError(\"You cannot initialise abstract class\")
class dog(animal):
    def talk(self):
        print (\"Wuff wuff!\")
d=animal()
d.talk()

>>raise NotImplementedError(\"You cannot initialise abstract class\")
NotImplementedError: You cannot initialise abstract class"]
     ]
    ]
   [:p.tutorial-intro
    [:b "NOTE: "]
    "Not every exception is exceptional enough to be caught, infact it is the responsibility of the programmer to decide which exception should be caught and which shouldn't.
In general, you should avoid catching IndentationError, SyntaxError , NameError as they are due to programmer mistakes."
   [:br] [:span "There are obviously a lot more errors in the language. I encourage you to explore the docs and hopefully they look a little less scary this time around."]
    ]
   
   
   
   ])
