## Memory Management ##

* Java has **automatic memory management**. This includes the **JVM** 
  establishing the **stack** and the **heap**. The **string pool** for string
  memory efficiency. Java creates sizes of primitives for you. **Primitive**
  value size specifics; and **garbage collection**. 

* **Stack and the heap** are **locations** in memory established by the JVM
  before an application starts. 
  
* **The stack** is the **execution flow** of the application. Starts with 
  **main method** and then builds up and down based on **method calls**. 

* **The heap** is a generally unorganized **section of memory** where objects
  are stored, not references. Virtual memory locations. Javas consideration 
  of memory locations in reference in where it starts in **RAM**. Thus the
  **string pool** is a section of the **heap**. Heap is a data structure,
  in math and programming. It is unorganized. 

* **Garbage collector** is a JVM process. Runs independantly of program stack.
  It is responsible for **releasing memory** in the heap that is no longer being 
  used so that it can be reused later. The **GC** identifies objects as 
  no longer in use by determining if there is a **reference to that object**
  anywhere in the program. When all references to a object leave **scope**
  the object becomes available for **GC**. It is not constantly cleaning 
  objects. It runs periodicaly. The next time the **GC** checks that object, 
  the memory will be released for reuse. Background process. Keeps track of
  memory usage. The **GC** cannot be forced to release memory. It can be 
  suggested to do so with `System.gc()` method but the logic that invokes is
  complex and will not always result in the **GC** actually running the process
  of checking for eligable objects in the **Heap**.

* **The Object Class** (superclass of all classes) - `finalize()` - This method
  is called by the **GC** for every object before it is released from memory.
  This is used to cleanup any resources or references from the object before
  it is collected. If there is something on the object that needs to be freed.


## Threads ##

* **Thread** has a single stack, single execution row. Not good for procesing
  efiiciency (single threaded). Threads are ways to execute parallel exection
  flow. `Thread` is an object. This essentially "splits" the stack into
  seperate independant **branches**. Note that all Threads still referenece
  the same **heap** and are part of the original **stack**. 2 threads accessing
  objects at the same time can be a problem. Threads can speed up execution
  for processing that can be performed in parallel.

* **Servlets** are multithreaded. New thread for every request. Multiple people
  using program at same time. 
  
* Threads can conflict. Trying to manip. same object @ same time. 
* Java has functinality to prevent these issues wiht the `synchronized` non-
  access modifier. `synchornized` means that when a Thread uses or references
  an **object/method/field** that thing is **locked** and cannot be
  accessed by another thread until released. Dont `oversynchronize`, it is 
  inefficient

* Outide of  `synchronized` there is very little control got how multiple threa
 das will have in relation to each other.

 * **Thread States**
  * New - Created
  * Runnable - Started or waiting to start.
  * Blocked - Waiting on synchronized resource
  * Waiting - Paused for unspecified amount of time.
  * Timed_Waiting - Wai for specific amount of time
  * Terminated - Finished and resolged 

* **Thread Methods**
    * `.run()` - This is the method that holds the execution flow for the 
      thread. This is the individual threads **mini main method**. 

    * `.start()` - This will execute all the logic for having the JVM create 
      the seperate flow for Thread and then calls `.run()` method. If you call
      `.run()` directly, it will execute in the same thread that isrunning. 
      will not create a branched execution flow. 

    * `isAlive()` - If thread is running
    * `static Thread.currentThread()`- Returns the thread is currently executing
    * `static Thread.sleep()` - Wait for specific amount of time.

    * Creating Threads - 2 basic ways to create threads, and 1 more complex
      modern abstraction way.

    * Extend `Thread` class and override `.run()`.

    * You can call the Thread constructor that take a `Runnable` and pass the
      run method logic in as a **lambda function**. 
          * Functional interface, no parameters returns void.
      
    * JAva has a built in `Executor` interface to create and manage threads.
    This still makes use of lambad and the runnable interfae.

    * Executors create **thread pools** which ar no efficient, Creating a num
    of threaf anf managing tne for u ensuring that always have THering objets 
    and not more

* **Deadlock** - 2 threads are trying to access multiple synchrnoized
  objects and none of them can gain all the objects/resources that
  they need to complete so no thread can proceed.

* **Livelock** - The threads have been instructed to release resources
  if they cant perform their tasks but they both give up and then 
  recapture the same resource preventing progress. An infinite loop of
  releasing and capturing resources.

* **Starvation** - One thread is holding onto resource for significantly
  longer than necessary. The causes all other Threads to wait, slowing
  down the process. 


## Stream API ##

* Builtin class wiht functionality to process collections of data in non-
blocking queue. Much like threads is about efficiancy The stram API is a java 8 featutre allows for processing of collections of objects in a non blocking
queue Allows for bulk operations to be performed on each object in the colletion
much like d for-loop but does so in effivient ways. Take advantage of 
multi-threading. Ddefines the the Stream<T> interface. Note: The stream API
and Strean interface are ddistinct from input/output streams

* Like Scanner or BufferedReader : Steam of data external to Java

* Stream api is concerned w/ objects IN application
  * The stram source The source is unchanged

  * Intermediate operations - The logic will be defined via lambda expressions
    that the methods take.

  * Intermediate operations always return a stram object. This allows themto
    be chained together.

* Terminal operation - Terminal operations are methods on the stream interface
  that do not return a stream and therefor are the las tmthod called on the
  opertaion. These will generally return a new collection of the modified
  objects. `.collect()` which returns a list.
