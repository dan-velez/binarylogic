## Spring Data, JPA, and Hibernate ##

* Tomcat is needed for raw servlets.
* View Resolver returns static files.
* Returning from controller a String triggers the View Resolver. Looks for a 
  static file. `ResponseBody` knows to return a JSON object. 

* Spring is managed by **VMWare**.

* Servlets are the foundation of web applications in Java EE and are used to 
  handle HTTP requests and generate HTTP responses.

* Servlets are the foundation of web applications in Java EE and are used to 
  handle HTTP requests and generate HTTP responses.

* In **DI** classes are self contained. Adding an **annotation** injects the 
  class in the appropriate **application layer**. 

* **DI frameworks** usually use XML for configuration that specifies who to pass
  to and where. 

* **Spring Data JPA** - Very high abstraction layer. Need to understand inner
  workings. Entire repository persistence layer is abstracted. Annotate model
  layer and write interfaces. Connecting to DB is easier.

* Why ORMs exists? What are ORMs? 

* Working with JDBC and by extension SQL and Java at the same time leads to 
  issues: **Context switching** from OOP to RDBS. To address this problem,
  frameworks that were capable of converting OOP objects into SQL records
  and back were created so that developers could focus on OOP scenarios and
  not worry about SQL structures. These are called **Object Relational Mapping**
  frameworks. ORMs. 

* Take an object and map it to a database. Or record to OOP object. 

* The **Java Persistence API** (JPA) is a standard for Java ORM creation. If
  you want to create an ORM framework, use JPA. This allows you to swap ORM
  frameworks such as **Hibernate**. Hibernate is the most common implementation
  of JPA, was the inspiration for the **JPA**. 

* **JPA** requires **mapping** your **entities** to the database. An **entity**
 is a collection of data that needs to be represented throughout the application
 components. Thus this data will need to be dispayed in the front-end, 
 manipulated in the back-end and persisted in the database.

* Entities are at various stages of their existence **objects**, **records**, 
  and **view structures**. This allows us to talk about this data without being
  tied to a particular paradigm. JPA does this **mapping** with **Annotations**
  on **model classes**. 
    
    * **Spring JPA Annotations**:

    * `@Entity` - Indicates to ORM this class represents a **model** or entity
      in the db. This will create a table to hold them.

    * `@Table` - An optional annotation that allows an entity to mapped to an
      existing database or table or to allow manual configuation of table.
      This lets you set the name of the table in the DB.

    * `@Column` - An optional. Fields of classes will be mapped to columns in
      database. Allows to set column properties such as name and constraints
      like `NOT NULL`.
        
    * `@Transient` will allow a field not to be mapped.

    * `@Id` - Primary key / unique identifier for Entity. 

    * `@GeneratedValue` - This can auto generate primary keys for column.

    * `@ManyToOne`, `@OneToMany`, `@OneToOne`, `@ManyToMany`.- Inidicates
      relationships between entities in the database. 

    * `@JoinnColumn` - This is used with the various multiplicity annotations
      to inidicate what column FKs point to or if a Join is necessary.

## Hibernate ##

* **Hibernates** DDL.auto property - This will set the level of access that
  hibernate is allowed when it comes to DDL commands. 

    * **Validate** - No DDL permissions. Hibernate will query schema to ensure
      entities are properly mapped at creation. Check tables match entity
      columns. Will throw exception if it cannot map correctly.

    * **Update** - Can create new DB structures or update existing structures.
      Cannot DROP any structures. Most common setting. New fields/classes,
      auto added to DB. Existing structures are not lost.

    * **Create** - Drops all structures at startup each time app runs and
      recreates them. There is no persistence between runs of the application.
      This is used early in development. Can only drop structures it is aware
      of. If class names are changed, the existing stays. 

    * **Create-Drop** - Drops all DB structures When app shutsdown. This will
      give a completely clean database each time the program runs, avoiding 
      the phantom table problem.

## Repository ##

* Base interface implemented by the framework.

* **CRUDRepository** - Provides basic CRUD functionality.
* **PagingAndSortingRepository** - Adds sorting and paging.
* **JpaRepository** - Adds Jpa Functionality. Recommended. 