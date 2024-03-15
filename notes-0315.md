# Notes 03-15-2024  Binary Logic #

* Methods are functions that are defined in a class. Blocks of resusable code.
* Take inputs and return outputs.
* Inputs are arguments or parameters.

* Methods contain 3 major parts:
    * The declaration or **method signature**.
        * The method signature include the **access modifier**, 
            any **non access modifiers**, the **returun type**, the **name**, 
            and any **parameters**.
    * **Code Block**
        * Contains the code that the method will execute.
    * **Return Value**
        * Not required. This is declared in the code block. No code will execute
          after the method returns.

* Methods must have a **return type**. This is the type of value that the method
  returns. They can only return a single value.

* If they dont return anything, they return **void**.

* **Non Access Modifiers** are indicators for how the method should be handled
  by java. There are many non access modifiers. The primary one is **static**.
  **final** is another.

* A **static method** is functionality that belongs to the class itself, not to
  individual objects. ALl objects of that class share the same static method.
  THis means that the method can be called without the creation (instantiation)
  of an object.

* The **main method** is ran without creating an object.

* **Final** is a non access modifier that means the method cannot be overriden.
  This means a child class cannot change the method it inherits.

* Other non access modifiers include **synchronized**, **volitile**, 
 **abstract**, **transient**, **native**.

 * Cannot be **abstract** and **final**. Can have **final static synchronized**.
 * Can **combine** non-access modifiers
 
 * The order (and type) of paremeters in a method **do** matter. Order and 
   number of parameters.

* **Constructors**: specialized methods that create objects from classes.They
  are invoked or called by using the 'new' keyword.

* Constructor function essentially like static methods except they do not have
  a return type. The return is the object it creates. Must have the same name
  as the class name.

* You can have **multiple constructors** for a class. this follows the same
  rules as method overloading. If a constructor is not excplicitly defined
  in the code, then the compiler will attempt to write it's own constructor
  for the class. This is called the **default no-args constructor**.
  It take no args and only calls the no-args constructor of its parent class.

* If you provide a constructor to a class, the compiler will no longer provide
  the **default constructor**. 

* The first line of a constructor must be a call to **super()** or **this()**.

* **super** is a keyword indicating the parent class of the object.

* **this()** is a reference to the object itself, in the case of constructors,
  calling **this()** calls another constructor in the same class. This is
  usually done when you have multiple fields you may or may not fill at 
  intialization so you dont have to rewrite the logic for setting the fields.
  This is called **constructor chaining**. 

## Inheritance ##

* Inheritance allows another class to extend upon it.
* Can only inherit from 1 parent class.
* Multiple child classes.
* Use **extends**.
* It is  used for code reusability.
* Groups of objects sharing common features.
* **Super Class**

* Method **overloading**.. same name but different arguments.
* Return types may be different.

* Method **overriding** is inheriting a method from a parent class.
* Different functionalities but similar **signature**.
* Overriding is **same arguments** and **same name**.
* Calling from subclass. Return types should be the same.

* **overloading** can change signature. **overriding** use **@Override**.

```java
public class Animal {
    public void makeSound() {
        System.out.println("Generic Animal Sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

public class Main {
    public static void main (String[] args) {
        Animal dog = new Dog();
        Animal animal = new Animal();
        dog.makeSound();
        animal.makeSound();
    }
}
```

* **@Override** annotation is optional.
* **@Override** forces the compiler to find an overriding method.

* **extends** permits the object to inherit the methods and values. It will have
  the exact same **values and methods** as the parents unless **overriden**.

  * **Overloading** allows developers to have flexible, cleaner code providing
    multiple entry ways to a function.

* **Overriding** allows developers to customize behaviors of parent classes.

* toString -> String representation. Override in **model classes**.
* Java Beans requires overriding **hashcode()** and **toString()**.


## Arrays ##

* Arrays in java are **data structures**: they are a means of collectiong various
  values into an organized structure so they can be accessed together.

* Java Arrays store values sequentially in memory. This allows access to a 
  single value to be very fast. Memory mgmt. 5 bytes = 40 bits of data.

* 4 integers is 16 bytes of data. **O(1)** access time in arrays.

* Java Arrays must know:
    * data type.
    * size.

* This means, the len is **immutable**.
* Need to create a new array to **append**. Find a new space in memory.
* Object arrays are arrays of memory locations on the heap.
* Arrays are **typed**.
* Length and type are **immutable**.
* Arrays can have other arrays.
* For **mutable** type, use other data structure.

* Java arrays have index numbers assigned to each value they contain, in order.
  0-indexed. 

* Some data structures cannot be primitive based.