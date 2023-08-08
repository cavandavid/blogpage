(ns cavan-blog.tutorials.python.collections)
(def view
  [:div.container 
   [:div.row>div.col-md-12

    [:div [:img.python-heading-images.center-img {:src "images/collections.png"}]]
    [:p.tutorial-intro "Collections are container data types whose members may either be of the same type (Homogenous) or of different types (Heterogenous). We will be covering some of the more significant collection types in this module"]
    [:br]
    [:b "1. Strings"] [:hr]
    [:p "Strings are immutable sequences of unicode codepoints. Immutable in the sense , once created it cannot be changed. Let's start playing around with them :-"]
    [:pre>code.language-python "#Defining a string

my_string=\"Hello World\"
print(my_string)

>>Hello World

#You can also concatenate strings to form new strings

my_string=my_string+\", I hope you have a nice day!\"
print(my_string)

>>Hello World, I hope you have a nice day!   "]
    [:p "Hold up, i thought we established that strings are immutable i.e once created we cannot change or alter them , then how did we change the value of my_string by concatenating two strings? Here's what's happening behind the scenes"]

    [:p "When we initialise my_string = \" Hello World \" , what happens is a string object is created who's value is \" Hello World \". The variable my_string is simply a reference to this object as in python a variable does not directly store the value but is simply a memory reference to the actual data."]
    [:p [:b "my_string=my_string+\", I hope you have a nice day!\" "]
     ", this line takes the string object that is pointed by variable my_string and concatenates it with \", I hope you have a nice day! \". This value is stored in a new string object which can be referenced by variable" [:b " my_string"]]
    [:p "Some of the string built in functions are"]
    [:ul
     [:li [:b ".upper() and .lower()"]
      [:pre>code.language-python "s= \"I wish i could get some SLEEP\"
print(s.upper())
>>I WISH I COULD GET SOME SLEEP
s= \"I wish i could get some SLEEP\"
print (s.lower())
>>i wish i could get some sleep"]]
     [:li [:b ".find()"]
      [:pre>code.language-python "s= \"Bran is actually the Night King\"
print(s.find('is'))
>>5"]]
     [:li [:b ".replace()"]
      [:pre>code.language-python
       "s='Jon is the true king of the North'
s=s.replace('Jon','Hodor')
print(s)
>>Hodor is the true king of the North"]]
     [:li [:b ".join()"]
      [:pre>code.language-python
       "s=['Arya','Sansa','Jon','Danny']
s=\"#||#\".join(s)
print(s)
>>Arya#||#Sansa#||#Jon#||#Danny"]]
     [:li [:b ".partition()"]
      [:pre>code.language-python
       "s=\"Lets watch Game of Thrones or Breaking Bad\"
s=s.partition('or')
print(s)
>>('Lets watch Game of Thrones ', 'or', ' Breaking Bad')"]]
     [:li [:b ".split()"]
      [:pre>code.language-python
       "s=\"Arya#||#Sansa#||#Jon#||#Danny\"
s=s.split('#||#')
print(s)
>>['Arya', 'Sansa', 'Jon', 'Danny']"]]]
    [:br]
    [:p [:b "2. Lists"] [:hr]
     "Lists is a mutable collection of heterogeneous items. Mutable signifies we can add,remove or modify items from the list. Heterogeneous signifies the members of list need not be of same data type."]
    [:pre>code.language-python "#Defining a list

my_list=[1,2,3,4,5]
print (my_list)
>>[1, 2, 3, 4, 5]

#Appending to list

my_list.append(29)
print(my_list)
>>[1, 2, 3, 4, 5, 29]

#Editing contents of list
my_list[0]=100
print(my_list)
>>[100, 2, 3, 4, 5, 29]

#We can also create a copy of the list
copy_list=my_list[:]"]
    [:p [:b "3. Dictionaries"] [:hr]
     "Dictionaries are an unordered collection of key value pairs, where in the keys are of immutable type(string, numbers etc.) and values are mutable type. The keys are unique in a dictionary."]
    [:pre>code.language-python
     "#Defining a dictionary

my_dict={'Java':'Compiled Language','Python':'Interpreted Language','C++':'Compiled Language'}
print(my_dict)
>>{'Java': 'Compiled Language', 'Python': 'Interpreted Language', 'C++': 'Compiled Language'}

#Accessing Value by using key as reference

print (my_dict['Java'])
>>Compiled Language

#If we try to accesss the value of a key that does not exist we will get an error

print(my_dict['Ruby'])
>>KeyError

#Editing dictionary

my_dict['Python']='Dynamically Typed Language'
print (my_dict)
>>{'Java': 'Compiled Language', 'Python': 'Dynamically Typed Language', 'C++': 'Compiled Language'}

#If we try to update a key that does not exist, a new value will be added to the dictionary.

my_dict['C#']=\"Compiled Language\"
print (my_dict)
>>{'Java': 'Compiled Language', 'Python': 'Dynamically Typed Language', 'C++': 'Compiled Language', 'C#': 'Compiled Language'}
"]
    [:p [:b "4. Tuples"] [:hr]
     "Tuples are immutable sequences of random objects. Tuples are more strict as compared to lists, in the sense, once created, the objects in them cannot be modified or deleted."]
    [:pre>code.language-python
     "#Defining a tuple

my_tuple=(\"India\",\"1\",\"2.0\")
print (my_tuple)
>>('India', '1', '2.0')

#Accessing elements of tuple

print (my_tuple[0])
>>India

#As mentioned above we cannot alter objects in a tuple.

my_tuple[0]=\"Australia\"

>>my_tuple[0]=\"Australia\"
TypeError: 'tuple' object does not support item assignment"]
    [:p [:b "5. Sets"] [:hr]
     "Sets are mutable sequences of unique immutable objects. The set in itself is mutable meaning we can add or remove elements,however its members have to be immutable like strings, numbers, tuples etc. Sets are unordered , which means unlike lists we cannot access its members using their index position."]
    [:pre>code.language-python "#Defining a set

my_set={1,2,3,4,5}
print (my_set)
>>{1, 2, 3, 4, 5}

#Accessing elements of set

print (my_set[0])
>>print (my_set[0])
TypeError: 'set' object does not support indexing

#Sets store only unique values so even though our collection has duplicates, it will store only those values which are unique.

list=[1,2,1,3,4,52,4,2]
set=set(list)
print(set)
>>{1, 2, 3, 4, 52}"]
    [:p "Adding elements in a set"]
    [:pre>code.language-python
     "#Use add() method if you want to insert a single entry

my_set={1, 2, 3, 4, 52}
my_set.add(200)
print(my_set)
>>{1, 2, 3, 4, 200, 52}

Use update() method to add multiple entries in a set

my_set.update({200,12,34,45})
print(my_set)
>>{1, 2, 3, 4, 34, 200, 12, 45, 52}"]
    [:p "Removing elements from a set"]
    [:pre>code.language-python
     "#Using remove method

myset={1,2,3,4,5}
myset.remove(3)
print (myset)
>>{1, 2, 4, 5}

#The problem with remove() is that if specified element is not present in set it raises a key error

myset.remove(10)
>>myset.remove(10)
KeyError: 10

#Another way to remove entries from a set is discard() method, this is considered as a better approach as it does not throw a KeyError even if the specified value is not present in the set

myset={1,2,3,4,5}
myset.discard(10)
print(myset)
>>{1, 2, 3, 4, 5}"]]
   [:p "Sets support a wide range of mathematical operations like intersection, union, difference, issubset, issuperset etc.
I encourage you to take some time and try out all the different methods related to colection types."]
   ]
  )
