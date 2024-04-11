# Functional Programming #

* OOP was created by xerox.
    * Adopted by Windows.
    * Java in 90s.

* Pass around functions. Treating functions as inputs. Input functions into
  other functions or methods. Not done by Java initially.

* Functional interfaces and lambda expressions introduced in Java 8.
* Was popular in Javascript.

* Revolves around the concept of treating functions as if they are parameters/
  objects that can be passed around an applciation. Java 8 added support
  via **functional interfaces** and **lambda expressions**.

* Functional interfaces are interfaces that have a single abstract method
  defined. The **lambda expression** are the syntax for creating an
  **anonymous**, **inline**, implementation of that single method. Java creates
  a class that implements that function. 

* Set parameters to take particular interface. 

* Lambdas allow us to quickly define interface implementations.

* Lambda expressions are syntactically similar to javascript arrow functions.
  The inherit JS's **loose concern with strict syntax** allowing for many
  parts of the expressions to be optional in certain contexts.

* The full syntax is:
```java
(int param, String input2) -> { return param++; }

(int x, int y) -> { System.out.println(x++ +""); return ++x; }

@FunctionalInterface

/* Runnable interface. */
public class test implements Runnable {
    @Override
    public void run();
}
```

* There are many built in **functional interfaces** used in JRE libs and will
  be utilized in external libs. You can also define your own functional
  interfaces with the `@FunctionalInterface` annotation.

* Some built in **interfaces**:
    * `Runnable` takes no input and has no return. Used for creating threads.
      Signature is `public void run ();`

    * `Consumer<T>` - takes 1 input and has no return. 
      `public void accept (T t);`

    * `Function<T, R>` - Takes 1 input and returns 1 output.
      `public R apply (T t);` 

    * `BiFunction<T, U, R>` - Takes 2 inputs and returns one output.
      `public R apply (T t, U u);`

    * `Predicate<T>` - Takes 1 input and returns a boolean.
      `public boolean test (T t)`

    * `Supplier<T>` - Takes no inputs and returns output.
      `public T get ();`