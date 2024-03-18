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