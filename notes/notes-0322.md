# Notes 03-22-24 #

## GIT ##
* Version control. Save points in application.
* Can always revert back to a save point.
* Branches are used for different versions of a project.

## Databases ##

* **Contraints**:
    * Placed on columns and they limit the acceptable data that a column can
      take.
    
    * The column **datatype** is a constraint. There are other contraints. they
      can be applied to a single column or applied accross multiple columns.

    * These include **UNIQUE**: No exact duplicate values may exist in the row
      for that column. 
        * **NULLS** are not considered values, therefor may have multiple
          entries in a **UNIQUE** column.

    * If the contraint is spread accross multiple columns, the combined values
      must be unique, not each column values, e.g. UNIQUE accross first_name
      and last_name can still take "bill" and "smith" in one record and 
      "bill" and "black" in another record, even though they have same first
      name value.

    * **NOT NULL**: A column may not have a NULL value.

    * **DEFAULT**: Inserts an initial value for a column or columns if one is
      not initially provided.

    * **CHECK**: Provides a logical check for column. Usually its that the value
      cannot be less than zero.

    * **PRIMARY KEY (PK)**: Combines unique and not null to create a unique
      identifier for every row.
      
    * **FOREIGN KEY (FK)**: This indicates a column referecnes a value (usually
      a PK) on another table. This forms relationships.


* **Multiplicity (Relationships, Cardinality)**:
    * Relationships are connections between SQL tables. Thee are descrived
        by their multiplicity or cardinality.

    * 1:1 (one to one)
        * A value from 1 table is associated uniquely with a single value
            from another table.  
        
        * Achieve by having a UNIQUE FK
    
    * 1:n or n:1 (one to many or many to one)
        * an individual record on one table can be referenced by multiple records
          on another or vice versa.
        
        * Achieved with a non unique FK.
        * Person to bank accounts (example).
        * User to purchases (example).

    * n:n (many to many) 
        * Individual record on one table may be referenced by multiple records
          on another. Those records may reference multiple records on the
          first table as well.
        
        * Students to Classes (example).

        * Achieved using a JOIN table which forms 1:n relationships to each
          of the other tables, allowing for multiple references in each
          direction. The join table will have 2 columns, a non-unique fk to
          each table. 3 tables: 2 entity tables and a table tracking the joins.

* **Data Types**:
    * SQL has various data types that function as constraints on columns 
      indicating the type of value that column can recieve.

    * Data types are pretyy standard accross dialects but each will have a few
      unique types.
    
    * MySQL Types:
        * **VARCHAR (MAX LEN)** - Like a string in Java.
        * **INT/INTEGER** - WHole signed number, 4 bytes.
        * **TINYINT** - whole signed number, 1 byte.
        * **SMALLINT** - whole signed number, 2 bytes.
        * **MEDIUMINT** - whole signed number, 3 bytes.
        * **BIGINT** - 8 bytes.
        * **BOOL** - true and false represented as 0 or 1 in a TINYINT.
        * **NUMERIC (size, precision)** - A decimal number with a max number of
          digits equal to size and a number of digits after the point equal to
          precision E.g., 345.67 would fit in a **NUMERIC(5, 2)**.
        * **TIMESTAMP** - A specific moment in time. Format is 
            `YYYY-MM-DD hh:mm:ss`.
        * There are many, many more...

* **JOINS**
    * WHen creating a query, you can combine tables via a logical connection
      between associated columns. Generally a PK to FK relationship.

    * Create temporaty tables that display the result of the query.
    * Join Types:
        * **INNER JOIN** - Select only records that have information present
          in both tables to display.
        
        * **LEFT JOIN** - Shows all records from the left table and associated
          records from the right table. Records that dont have an association
          will show null values for the columns from the right table.
        
        * **RIGHT JOIN** - Reverse of the left join.

        * **OUTER JOIN** - Show records from both tables, combining where there
          is an association. MySQL does not have native support for OUTER JOINS
          and requires using a UNION of a LEFT and RIGHT JOIN.

        * **SELF JOIN** - Tables may join with themselves if there is a logical
          relationship. E.g., an employees table may have a FK refrence to
          itself for the employees manager which then could self-join an
          INNER JOIN to show the employee information with their managers info
          at the same time.

          * VENN DIAGRAM - INNER Join is middle part, left is left + middle, 
            right is right + middle, 

* **UNION**
    * Will combine 2 tables rows into 1 temporary table instead of combining
      columns like a JOIN. Stack tables on top of each other.
      E.G., if I have seperate purchase order tables for each quarter of the
      year I can combine them into a years total purchases. This does not
      work if you have different number or data types of columns in the 
      unioned table.

* **Sub Queries**
    * Queries within queries. Because a query returns a temporary table, 
      you can then query that table with an aditional query to get the
      necessary results. 

    * Subqueries usually benefit from using aliases. You can give the resul of
      a query a name to use further in the query statement using the "AS" 
      keyword. This is an **alias**. E.g., table `x` from a JOIN.

* **VIEWS**
    * Can be used to create virtual tables that are essentially constantly 
      available and updated queries that can be accessd directly by their name.