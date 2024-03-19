# Notes 03-18-2024  Binary Logic #

* **Abstract Classes**:
    * **Abstract**: Theory but not practically applied.
    * Classes which cannot be instantiated but can hold abstract methods.
    * Must be **inherited** in order to use. 
    * Exist only to be **parent classes**.
    * They may **not** be **final**.
    * An **abstract method** is a method that has a **signtaure** but no
      code block. 
    * **Can** have concrete methods. Doesnt **need** to have abstract methods.
    * An **abstract method** must be in an **abstract class**.

    * The implementation must be defined in the concrete classes that 
     **inherits** the abstract method. If a class inherits an abstract method, 
     it must  override it with a concrete implementation, or be an abstract 
     class. 

    * Often used in **libraries** that leave methods for developers to create.
      Context dependant methods.

    * Do not **require** there to be abstract methods in the class and they 
      may contain concrete methods as well.

* **Interfaces**:
    * Interfaces are structures in Java that are entirely made up of 
      **public abstract methods** and **public static final variables**.
      (Constants).
    
    * Generally **abstract methods**. A class may **implement** (keyword)
      **multiple** interfaces as is necessary. **Methods MUST be overriden**.

    * Removes chance of ambiguity. Overriding a simliar method in both parents
      overrides **both methods at once**. 

    * **Interfaces** are often discussed as **contracts**, ensuring that a class
      will have certain methods available.

    * In **Java 8**, the default keyword was added to interfaces allowing for
      methods to have a concrete default implementation in interfaces. Allows
      for updating abstract classes with default methods without users having
      to override every method.

    * Strings are comparable based on character value, not memory location.

    * Interfaces can **inherit** other interfaces using **extends**.
    * Interface can **inherit multiple interfaces** this way.
    
* **Throwables**:
    * If a Java program encounters a problem during **runtime** that it does
      not know how to resolve it will result in a throwable. Throwables are
      objects that interrupt the execution flow of an application when they are
      "thrown". A throwable will interrupt the application which will not 
      continue until the throwable is resolved. If it is not resolved, the
      program will crash.
 
    * There are 2 types of throwables: **Exception** and **Errors**.
    * **Errors** are problems that the Java program cannot under normal 
      circumstances be expected to recover from.

    * These are things like **StackOverflowError** which means there is no more
      ram memory available to manage method calls on the stack. 
      **OutOfMemoryError** is similar.Usually therefor it is best not to attempt
      to resolve Errors during runtime, but rather refactor the code base if 
      theyare commonly encountered. 

    * **Exceptions** are problems that Java can be expected to recover from.
      **FileNotFoundException** and **ArrayIndexOutOfBoundsException**.

    * Compiler Errors are problems that are encountered at comile time and are
      not objects in a running program. Thus are not throwables. They simply
      indicate that the program cannot run because it cannot compile.
    
    * Exceptions are 2 categories: **Checked Exceptions** and **Unchecked**
      (runtime) Exceptions.

    * **Checked Exceptions** are issues that are anticipatable but not 
      capable of 100% being avoided by application logic. FileNotFound,
      DatabaseClosed.
    
    * **Unchecked Exceptions** can always be avoided with application logic.
    
    * When a method that can result in a **checked exception** is called, the
      compiler will require that exception to be handled before it will allow
      compilation. **Checked** are **checked by compiler**.

    * Unckeded exceptions are not required to be handled because it is not 
      forseen to be unhandled.

    * Errors are unchecked. Exceptions are checked by compiler. 
     **RunTimeExceptions** are unchecked: NullPointerException, 
     ArithmeticException. 

    * Handling Exceptions: Try/Catch/(Finally) blocks. For this you identify a 
      block of code with the keyword "try" that may produce an exception or
      exception(s). Then you write code blocks with the catch keyword and the
      type of exception that will be caught to indicate what should happen 
      should that exception be encountered. 

    * You can have multiple **catch** blocks. One for each exception type.

    * Only one **catch** block will ever run. And it will be the first 
      catch block that fits the exception type. Structure blocks from
      most specific to least specific to avoid **unreachable code**.

    * A **finally** block can be declared under catch blocks. This code will
      always run at the end of a try or catch block. This is done to clean up
      resources, etc. So that exceptions don't accidentially create memory
      leaks or large objects that are not being used anymore.

## Collection Framework/API ##

* This is a framework in **java.util** of predefined data structure classes and
  utility tools for manipulating them. 

* The framework uses **generics** to define implementations. This means that
  the various classes will work with any type of **java object** including
  **custom objects**.

* Generics use **<>** to define the type of value the structure will accept.
    * e.g. **ArrayList<String>** will accept Strings for a list.

* This means the collection framework classes **cannot accept raw primitives.**
* However, Java primitives can be **wrapped** into their **wrapper classes** and
  be treated as objects when necessary.
* Wrapper classes are 
    * **Boolean, Short, Byte, Integer, Long, Double, Float, Character**.

* Inheritance Heiarchy:
    * Iterable -> Collection -> List, Queue, Set 
        (ArrayList, PriorityQeue, HashSet, Dequeue, LinkedHashSet)

* interface java.lang.Iterable Methods: **forEach, iterator(), spliterator()**
* **Collection** inherits from **Iterable**.

* **Collection<E>** extends Iterable.


* **List (interface)** - Is a data structure. It has a dynamic (can change) 
  size that allows for duplicate values and maintains the order of insertion.

    * **ArrayList (Class)** - Uses arrays under the hood to store values. When
      more values are stored, the initial array is discarded and replaced with
      a new array 50% larger. **Lookup is fast O(1)**. Insertion is slow.  

    * **LinkedList (Class)** - LLs use nodes to wrap their elements in order to
      create the list. LLs in Java are doubly linked, so a node knows the value
      that preceeds it in the list and the value that proceeds it, but not the
      location of any other elements. DO NOT use arrays. Not **sequential** in
      memory. **Useful for insertion O(1)**. **Lookup is difficult**.

* **Sets (Interface)** - Data structure that is not required to be ordered. 
  does **NOT take duplicates**. Dynamic size.
    
    * **HashSet (Class)** - Unordered set. USes HashMap to store values. Uses
      hash values to determine order. It can take a single null value.
    
    * **TreeSet (Class)** - SOrted set backed by a TreeMap. Cannot take any 
      **null** values (unsortable).
    
* **Queue (Interface)** - A first in first out data structure. It is dynamically
  sized, maintains the order of insertion and has easy methods for accessing 
  and removing the first element (head).   

    * **Dequeue (Interface)** - Double ended queue. Combines the functionalities
      of queue and stack, allowing for elements to be removed or added to both
      front and end of queue.

    * **ArrayDequeue (Class)** - Implements a Dequeue and is std class for stack
      now that Stack is deprecated. Its values are stored in an array. 

* **Stack (Class)** - First in last out data structure. Dynamically sized.
  Maintains order of insertion. The Stack class is depricated and ArrayDeque is
  recommended for Stacks.  

  * **Maps (Interface)**:
    * Map is a data structure in the collection framework. Does not inherit from
      **iterable** or **collection**. They are not iterable. Represent
      **key/value** pairs. BOth keys and values can be **any type of object**
      defined for the map in the generic. E.g., **Map<String, Integer>** has
      String keeys and Integer values. Can solve a lot of problems with maps.
      **Goto data structure**.
    
    * **HashMap (Class)** - Orders itself using the hashes of the keys. It is
      considered to be **unordered**. 
    
    * **TreeMap (Class)** - Uses a **binary tree** to order elements in the map.
      Therefore the keys must be comparable so they can be ordered.
    
