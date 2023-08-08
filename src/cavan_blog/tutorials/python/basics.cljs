(ns cavan-blog.tutorials.python.basics)

(def view
  [:div.text-center
   [:div.container
    [:div.row.heading
     [:img.python-heading-images.center-img {:src "/images/basics.png"}]]
    [:div.row.text-center.tutorial-intro
     [:div.col-md-12
      [:p.text-center [:b "Python is an Interpreted Language"]]
      [:p
       "This means that unlike languages like C++, Java etc. , programs do not have to be compiled before being run."]
      [:br]
      [:p.text-center [:b "Python is a Strongly Typed Language"]]
      [:p
       "Every object in python has a type like int, float , string etc."]
      [:br]
      [:p.text-center [:b "Python is a Dynamic Language"] [:br]]
      [:p
       "This means that up until run time, the type of the object is not specfied."]]]
    [:div.row.text-start
     [:p [:b "Basic Functions"]]
      [:pre>code.language-python
       "def our_adder(object1,object2):    #def keyword is used to define a function, here our function has 2 parameters i.e object1 & object2
    print (object1+object2)

our_adder(2,3)      #Here we are calling the function we had defined earlier and passing arguments 2 and 3 to it
>>5                 #On passing integers, object1 and object2 behave as integers and perform addition operation

our_adder('2','3')      #Here again, we are calling our_adder function and this time we are passing strings to it
>>23                    #On passing strings, object1 and object2 behave as strings and perform string concatenation"]
      [:p
       "Don't worry if this seems too much to take in now, after a few modules it will be a breeze :), lets head to the basics."]
      [:p
       "Python has primitive data types such as int, float etc as well as collection data types such as lists, dictionaries etc. Lets go through some of them in detail."]]

    [:div.row.text-start
     [:p [:b "1. int"]] [:hr]
     [:p
      "Integers in python are signed(+ve or -ve) with no decimal point."]
     [:pre>code.language-python
      "#Integers are specified in decimal form by default
10

#They can also be specfied in binary by adding prefix 0b                
print(0b10)
>>2

#They can also be specified in hexadecimal by adding prefix 0x
print(0x10)
>>16"]]
    [:div.row.text-start
     [:p [:b "2. float"]] [:hr]
     [:p
      "Any number that has a decimal point or letter e is considered as a float by Python interpreter"]
     [:pre>code.language-python
      "a=10.0
print(a)
10.0

a=10e3
print ((a))
10000.0

#Any calculation between int and float will be converted to float
print(1+2.0)
3.0"]]
    [:div.row.text-start
     [:p [:b "3. bool"]] [:hr]
     [:p
      "Bool type is used to represent the state of an object. It can have only two value"
      [:b "True"]
      "or"
      [:b "False"]
      ". It also consists of bool constructor"]
     [:pre>code.language-python
      "#For number types(ints and floats) , all non-zero values are considered as True.

a=bool(1)
print(a)
>>True

a=bool(0)
print(a)
>>False

#For strings, only an empty string is considered as False

a=bool('')
print(a)
>>False"]]
    [:div.row.text-start
     [:p [:b "4. None"]] [:hr]
     [:p "None is used to display absence of a value. This blog is so meta that it refuses to show a snippet for null"]]
    [:div.row.text-start
    [:p [:b "5. Strings"]] [:hr]
    [:p "String is a collection of unicode codepoints."]
    [:pre>code.language-python
     "#Defining a string

name=\"Cavan David\"
print(name)
>>Cavan David

#Python has a number of built-in functions, one such is len() which isn't exclusive to strings but can be applicable to any iterable series(lists, dictionaries etc) which returns the length of the object.

print(len(name))
>>11

#Since strings are collection types, we can access any of its members by providing their index position. Remember, indexing always starts from 0.

print(name[0])
>>C"]]
    [:p
     "We will cover collection types in detail in a further module."]]])
