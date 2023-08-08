(ns cavan-blog.tutorials.python.misc)

(def view
  [:div.container>div.row
   [:div.col-md-12
    [:img.python-heading-images.center-img {:src "/images/beyond.png"}]
    [:h2 "Comprehensions"] [:hr]
    [:div.row
     [:div.col-md-6
      [:b "1. List Comprehensions"]
      [:p "Python lets you do some pretty cool stuff . One of them is List comprehensions. Using this technique you can significantly reduce your lines of code
Say we have a list and we want to calculate the square of all its members. Normally we would go about this as."]
      [:b "Example without List Comprehension"]
      [:pre>code.language-python
       "my_list=[1,3,5,9,11]
my_new_list=[]
for item in my_list:
    my_new_list.append(item*item)

print (my_new_list)

Output
[1, 9, 25, 81, 121]"]]
     [:div.col-md-6
      [:b "Example with List Comprehensions"]
      [:pre>code.language-python
       "my_list=[1,3,5,9,11]
my_new_list=[item**2 for item in my_list]
print (my_new_list)

Output
[1, 9, 25, 81, 121]"]]]
    [:hr]
    [:div.row
     [:div.col-md-6
      [:b "2. Dictionary Comprehensions"]
      [:p "The concept of comprehensions is also applicable to dictionaries. Let us solidify our understanding with an example
Say we have a dictionary and we want to swap its keys and values"]
      [:b "Example without Dictionary Comprehension"]
      [:pre>code.language-python
       "my_dict={'Jon':'Snow','Arya':'Stark','Robert':'Baratheon','Cersei':'Lannister'}
new_dict={}
for x,y in my_dict.items():   # .items() is used to iterate over the items of the dictionary.
    new_dict[y]=x     #Swapping the numbers and storing value in new dictionary
print(new_dict)

Output
{'Snow': 'Jon', 'Stark': 'Arya', 'Baratheon': 'Robert', 'Lannister': 'Cersei'"]]


     [:div.col-md-6
      [:b "Example with Dictionary Comprehensions"]
      [:pre>code.language-python
       "my_dict={'Jon':'Snow','Arya':'Stark','Robert':'Baratheon','Cersei':'Lannister'}
my_new_dict={y:x for x,y in my_dict.items()}
print (my_new_dict)

Output
{'Snow': 'Jon', 'Stark': 'Arya', 'Baratheon': 'Robert', 'Lannister': 'Cersei'}"]]]
    [:hr]
    [:div.row
     [:div.col-md-6
      [:b "3. Set Comprehensions"]
      [:p "And Lastly, how can we forget about our humble sets."]]


     [:div.col-md-6
      [:b "With Set Comprehensions"]
      [:pre>code.language-python
       "set={1,2,3,4,5,6}
new_set={item**2 for item in set}
print(new_set)

Output
{1, 4, 36, 9, 16, 25}"]]]]
   [:div.col-md-12
    [:h2 "Looping Techniques"] [:hr]
    [:div.row
     [:div.col-md-6
      [:b "1. Enumeration"]
      [:p "Enumeration allows you to have an ordered indexing associated with your collection. As always, an example will make things more clear."]
      [:p "Enumerate also allows an optional argument"]
      [:p [:b "NOTE:"] " Not just lists, enumeration also works with other collection types like sets, tuples etc."]]
     [:div.col-md-6
      [:pre>code.language-python
       "my_secular_list=['John','Ramesh','Suresh','Ahmed']
for index,item in enumerate(my_secular_list):
          print(str(index)+\". \"+item)

>>Output
0. John
1. Ramesh
2. Suresh
3. Ahmed"]]]

    [:div.row
     [:div.col-md-6
      [:b "2. Zip"]
      [:p "Zip allowed you to iterate two or more lists at the same time in a single iteration. Lets just into an example"]]
     [:div.col-md-6
      [:pre>code.language-python
       "my_secular_list=['John','Ramesh','Suresh','Ahmed']
greetings=['Hello','Namaste','Namaste','Salaam']
for x,y in zip(greetings,my_secular_list):
     print(x+" "+y)

Output
Hello John
Namaste Ramesh
Namaste Suresh
Salaam Ahmed"]]]]
   [:div.col-md-12
    [:h2 "Inheritance & Abstract classes"] [:hr]
    [:div.row
     [:div.col-md-6
      [:b "1. Inheritance"]
      [:p "Inheritance , as the word suggests is basically the act of transferring everything you own to your kin. In programming, it has similar meaning ,classes inherit all the functions and variables of their parent class."]
      
      ]
     [:div.col-md-6
      [:pre>code.language-python
       "class parent:               # parent class
    def property(self):
        return \"3 bhk flat in Colaba\"

    def marriage(self):
        return \"Arranged marriage with Sharmaji's beti\"

class son(parent):          # son class is inheriting from parent
    name=''
    def __init__(self,Name):
        self.name=Name

#Create son object
firstson=son('Cavan')       #Initialise son class and create object firstson
a=firstson.property()
b=firstson.marriage()
print(a+\" and \"+b+\" is given to my son Cavan\")

>>Output
3 bhk flat in Colaba and Arranged marriage with Sharmaji's beti is given to my son Cavan  "]
      [:p "Inheritance is aimed at code reusablility and easy scalability. If i wish to give my sons more assets, i can simply add it to my parent class, and it will become available to all it's children classes"]]]

    [:div.row
     [:div.col-md-6
      [:b "2. Abstract Class"]
      [:p "Abstract class provides a common interface for all of its subclasses to use. Similarly, methods that are declared as abstract get their function definition from the child class that implements it."]
      [:p "Python's abc module(Abstract base classes) allows us to implement the concept of abstract classes. A simple example will help solidify our understanding of abstract classes and abstract methods."]]
     [:div.col-md-6
      [:pre>code.language-python
        "from abc import ABCMeta, abstractmethod
class animal(metaclass=ABCMeta):    #Declaring class as abstract

    @abstractmethod                 #Declaring method as abstract
    def talk(self):
        print (\"Never going to get executed\")

class dog(animal):
    def talk(self):                 #Providing implementation details for abstract method
        print ('Wuff wuff!')

d= animal()                         #Trying to initialise abstract class
d.talk()

>>Output
TypeError: Can't instantiate abstract class animal with abstract methods talk

d = dog()
d.talk()

Output
Wuff wuff!"]]]]
   
   ])
