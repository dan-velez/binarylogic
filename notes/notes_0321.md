# Notes - Binary Logic 03-21-2024 #

* **Database**: Programs that allow for the input, management, storage, and
  retrievel of data. Traditionally, databases were structured in tables that
  were made up of columns and rows. The junction of a comlumn and a row was
  where a piece of data was stored. This is still the system used for 
  relational databases. 

* **NoSQL databases**, non-relational databases are now used.

* **SQL** - Structured Query Language. SQL is a **standard** for how relational
  database management systems (RDBMS) are constructed and their capabilities.

* **RDBMS** - A system for creating relational databases. A relational database
  is a database where data is **structured** in a way where **tables** can
  share **relationships** with each other. **Associating data** accross tables.
  Useful for performance of DB.

* **One-to-one, many-to-one, many-to-many**.

* **SQL Dialects**:
    * The SQL standard requires implementation. THese implementations use very
      similar syntax but have slight differences between vendorr or dialetcts.

      * Examples:
        * **MySQL**
        * **PostgresSQL**
        * **Microsoft SQL Server**
        * **Oracle SQL**
        * **IBM DB2**

* **SQL Sublanguages**:
  * Sublangagues are categories of the functionalities of the SQL standard. 

  * **Data Definition Language (DDL)**:
    * This is used to define the structures within the database. These elements
      include tables, columns, and databases themselves. Schemas are also
      considered database srtuctures in some dialects. MySQL user databases
      and schemas **interchangeably** as structures. 

        * The term **schema** can have 2 associated meanings in SQL. The first
          is the above, where it is a **database structure** concerned with
          organizing or grouping tables as a subset of the database.

        * The other meaning is to refer to the design of the database itself:
          primarily the way tables in the database are related to each other. 
          This is also called an **Entity-Relationship (ER)** diagram.
        
    * Kewords: **CREATE, ALTER, DROP, and TRUNCATE**. Keywords are usually
      capital.
        * **CREATE** - Generate new DB structure like a table.
        
        * **ALTER** - WIll change an existing database structure. Like a column
          on a table.
        
        * **DROP** - Remove an existin database structure like a table.
        
        * **TRUNCATE** - Will remove all data inside a database structure but
          leaves the structure still in the database.
  
    * **SQL** is a database scripting language.

  * **Data Manipulation Language (DML)**: 
    * Working with data inside **tables**.
    * Fills in or changes the cells of a table.
    * Subset of SQL concerned with handling data inside a table.
    * These are often defined as SQL's **CRUD** functionalities.
    * **CRUD** is a programming concept for basics of what most applications do.
    * Most applications we build are **CRUD** applications.
    
    * Keywords: **INSERT, SELECT*, UPDATE, DELETE**
      * **INSERT** ads new data into the table, generally a new row.
      
      * **UPDATE** change a record or row of the table, changing some data in a
        column or columns.

      * **DELETE** will remove a record or records. Can remove ALL rows at a 
        time and has same result as **TRUNCATE**. Delete can be targetted to
        specific rows, unlike **TRUNCATE**. 

      * **SELECT\*** - Access or read data from the table. **SELECT** statments
        are called **queries** in SQL.

    * **Data Query Language (DQL)**
        * Contriversial sublanguage in SQL. Some developers believe that SELECT
          should be considered a seperate sublanguage because it does not
          manipulate anything. Some delevopers recognize SELECT as part of DML
          due to CRUD, but some see **DQL** as a sublanguage of **DML**. SOme
          people will include **WHERE** as a **DQL Keyword** because it is
          often used with **SELECT** statments. However, it is also used with
          **DELETE** and **UPDATE** statements. 

    * **DCL**
    * **TCL**