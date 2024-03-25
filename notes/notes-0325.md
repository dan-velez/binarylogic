# Notes 03-25 #

* Scalar functions: Return an individual value for every value of the input.
*  Usually you will provide a column for the input and therefore you will 
   receive an equally sized column as the output.
* Example of Scalar functions: UPPER - changes varchars to all upper case
* LOWER - Changes varchars to all lower case.
* REPLACE
* REVERSE
* Aggregate functions return a single value on a a collection of inputs.
* SUN
* AVG
* MIN
* MAX
* Scalar anda aggregate functions are built in functions to the language and are 
  generally part of the SQL standard. Functions as blocks of logic to perform 
  programmatic functionality is possible in some SQL dialects but is not part 
  of the SQL standard.


**SET OPERATION**:
    * SET operations are ways of organizing or displaying the result of a query.
    * Order By - THis will order the results based on some natural ordering for 
    * the data type. The values can be ordered by ASC(ascending) or 
      DESC(descending) order. 


    * Set oprtations are ways of organizing or displaying result of query.
    * ORDER BY - Will result based on some natural ordering for data type. 
      ASC or DESC
    * GROUP BY - Allows for grouping related records with an aggregation.
    * **HAVING** - this is added toa GROUP BY clause to restrict the values that 
      are being grouped together.


    * SELECT SUM (course_number), duration FROM classes GROUP BY duration 
      HAVING duration > 70; 

JDBC - Java Database Connectivity 
    * Part of JRE
    * Prebuilting library
    * Provides a prebuilt solution for connecting to SQL databases and 
      interacting with them. These classes and interfaces are defined in the 
      `java.sql package`. Each SQL dialect will need their own implementation 
      of the JDBC’s interfaces and abstract classes for connecting to their 
      particular 
    
    * We will need external drivers.  

    * `JDBC java.sql.Connection` - An interface that represents a “physical” 
      connection to a database. Stream of data going back and forth to DB. 
      THis will be the object that runs SQL commands against the DB. 

    * `JDBC java.sql.DriverManager` - This is the class that is used to create 
      connection objects. It will require the DB credentials and location in 
      order to create a connection object.

    * `JDBC Statement and PreparedStatement` - Statements are interfaces. They 
      can be obtained from a Connection and represent a SQL statement that can 
      be run against the database.

    * `Statements` - These are precompiled SQL statements that can be directly 
      executed against the DB.

    * `PreparedStatements` - These will sanitize inputs into the statements 
      before compiling it and running against the DB in order to prevent SQL 
      injection.

    * `JDBC ResultSet` - Is an interface that represents the result of a query 
      performed on the DB. The interface has methods for iterating over the 
      results and accessing data column by column for each record retrieved. 