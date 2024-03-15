# Notes #

* JVM, JDK, JRE
* 8 Primitives:
    Boolean, byte, short, long, float, double, int, char 
* Everything else is an **object**.

## Strings ##

* **String** is a class.
* Objects.
* Default class is in **java.lang**.
* Class in **JRE Library** with **unique functionality**.
* The ability to declare **String Literals**
    * Creates a string object with a special syntax.
    * Wrapping the characters in quotes creates a **String Object**.
* Every object has a **toString** method.
* Strings hava a **concat** method.
* Concatentate calls the **toString** method in a concat operation.

* Primitives are **raw values**, objects take **functionality and value**.
* Primitives have **no methods or functionality**.
* Strings are **immutable**.
* Once it is created, the value cannot be changed.
* Strings are **permenant**.

* This is done with the **final** keyword. It is **immutable**. **Constant**.
* To modify, you need to make a copy of the **String**.
* **Reassigning** is permitted. 
* On creation of the object, the value is **assigned**.

* Methods and classes can be **final** also.

* Many **built in methods** in String class that allow programmer to create
  a new String object based on existing **String** value.

* We make copies of the Strings with methods, e.g. **concat** method will take
  the value of 2 existing **String** values and create a new string value with
  **combined values**.

* Java is a very **structured** language.

* Strings (and all objects in java) have a **.equals()** method.

* For strings, this method is changed (overriden) to compare the 
  **character values** that make up the string to determine euqality, instead 
  of the default functionality that compares **memory location**.

* **==** looks at **memory location** for every object.

* **.equals** looks at memory location for everything but **strings**.

* **String literals** are stored in a special place in memory called 
  the **STRING POOL**.

* Every program has a **string pool** for **string literals** (double quotes).
* Strings in **string pool** are unique. Thus, if 2 string literals are 
  declared with the **same value**, only **one object** is created in memory.
  
* Any variable assigned to that string literal will point to this object.
* This is why **strings are immutable**.

* Compiler replaces all duplicate strings to variables.
* Strings are immutable so the string pool can exist. This is for memory 
  efficiancy.

* **intering** is explicitly placing a string in the string pool.

* String copies are not literals. E.g., using substring to create a substring.

* Pass by value: primitives are raw values. Objects are mem locations.


## Input ##

* **Scanner** is a built in **java.util** package (**JRE**). Designed to read
  text from an external source. Can be a **text file** or inputs from 
  **console** or other text based resources. Generally static files. Creating
  a **Scanner** with the **System.in** value will create a Scanner connected
  to console inputs. Can be **JSON Object**.

* Scanner has many methods for getting particular types of values from an
  input. The std method is **.nextLine()** will consume (read) an entire line
  of text up to the next **line break character** and then discard it. There
  are others such as **nextInt()**, **nextShort()**, etc.. Take in primitives.
  However, these will leave any non-numeric or assoc characters in the 
  **buffer** that stores what the Scanner currently is looking at, meaning
  until it is cleared, the Scanner will NOT attempt to gain new inputs.

* Java can only close the connection to the console once. This is unusual for
  data sources and so Scanner will **throw warnings** that you are not closing 
  the Scanner during the running of the program. Cannot reconnect to the 
  console. Keep Scanner open for **console** applications. Thus you should 
  ignore those warning in relation to a Scanner connected to the console. 

* **Integer.ParseInt()** to convert ints into Strings.
* **String Typing** in Java.

* **Primitives** have lower case names.

* Cannot determine **string equality** using **==**.


## Classes and Objects ##

* Everything in Java revolves around classes and objects.
* All objects need predefined classes.
* In Java, any value that is being stored that is not a primitive is an 
  **Object**.
* Objects had **fields** and **methods.** Fields are variables that define the
  properties of the object. **Methods** are the functionalities of an object.

* Methods are functions that belong to an object. Since Java does not allow for
  functions not attached to an object. 

  * Classes are **blueprints** used to create objects. Does not define the 
    values of an individual object.

* Naming conventions: Java uses upper-case camel-case for class names 
  conventionally e.g. ThisIsAClassName.

* Classes that are degined to hold data elements of a program are called models.
  These have conventions for their creation. The two are POJOs (Plain Old Java
  Objects) and Java Beans.

## Access Modifiers ##

* Java allows for 4 visibility levels or access levels.
* Controls what other classes in your project can see and manipulate.
* This allows developers to encapsulate their code so that it is not used
in unintended ways elsewhere in the application.

* e.g. an age should never be a negative number, another programmer might set
  the age without knowing the class.

* To prevent this, age is restricted to only be set by methods in the person
  class itself. These methods ensure the values are controlled.

* Access levels:
    * **public** - accessible throughout the application.
    * **protected** - a property is available to classes in the same package, or
      subclasses of the class (classes in other packages).
    * **default** - package private. Same as protected but does not include 
      subclasses.
    * **private** - A property is available only to the class and objects of 
      that class.

    * **public/protected/private** are all keywords assoc with their level.
      Default there is no access modifier. 