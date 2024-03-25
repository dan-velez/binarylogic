# Notes on Input/Output Streams in Java #

* **java.io** package contains most of the I/O classes.

* I/O is divided into 2 parts:
    * Byte and number oriented IO -> Handled by **input and output streams**
    * Character and text IO -> Handled by **readers and writers**

* Both provide a class for external data sources and targets.

* Use the same methods to read from a **file, console, or network connection**.

* I/O streams that compress, encrypt, and filter from one data source to another

* With these classes, programs can send encrypted data or write zip files.

* Low level I/O using a PC's serial and parallel ports. 

* A **stream** is an ordered sequence of bytes. **Input Streams** move bytes
  of data into a program **from** some generally external source.

* **Output Streams** move data from a program **TO** an external source.

* AN **input stream** can be thought of as a **siphon** sucking in water 
* An **Output stream** is like a hose, spraying out water. 

* The siphon can run out of data if it is using a **finite** external source.
* An **output stream** can also have a limited number of bytes to write.

* Input in Java can come from many sources. 
* Output can go to many different destinations.

* **System.in** is a common source for input. Same as **stdin** in **C**.
* If a programs input is redirected, **System.in** is changed also.
    * E.g. `$ java MessageServer < data.txt`.

* Standard output in java is **System.out**.
* Standard error is **System.err**. Used for debugging and printin error.
```java
try {
    // do something
} catch (Exception e) {
    System.err.println(e);
}
```

* Both **System.out** and **System.err** print streams, instances of 
  **java.io.PrintStream**.

* Files are a common source for input and destination for output.
* Network connections provide streams too.

* Most stream classes are in **java.io**. The 2 main classes are
  **java.io.InputStream** and **java.io.OutputStream**. Abstract base classes.

* **java.util.zip** package has 4 input stream classes that read data in a 
  compressed format and return uncompressed format. ALso has 4 output stream
  classes that read uncompressed and write in compressed.

* **java.util.jar** has 2 stream classes for reading files from JAR archives.

* **java.security** pacckage contains 2 classes for calculating digests.

* Java Cryptography Extension has 2 classes for encryption and decryption.

* Input streams read bytes and output streams write bytes. Readers read chars
  and writers write chars. 

* THe **byte** class is heavily used in the **java.io** library.

* The **read()** method of **java.io.InputStream** returns the next byte of 
  data, or -1 if the end is reached. 