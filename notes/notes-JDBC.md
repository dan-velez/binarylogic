* **MAVEN**
    * Maven is a dependancy manager and build tool.

    * As a **dependancy manager**, maven will bring ino our projects, external
        libraries (bytecode libs and frameworks), not in the JRE.

    * Extend functionality of Java projects.
    * Maven has an XML configuration file for all its projects called
        **Project Object Model**, or **pom.xml**. 

    * Maven stores the libraries for projects locally on the machine in a 
        **.m2** folder and **downloads**, those libs from a remote repo by 
        default.
        
    * **mvnrepository.com** to search for repos.

* **DAO DESIGN PATTERN**
    * **Data Access Objects**
    * Encasulates dataa logic from business logic
    * CRUD and methods for querying data
    * User asks for thing from database
    * DAO accesses DB directyl  
        * password
        * username
        * connection
    * DAO is abstract class or interface
    * Business Layer -> DAO (JDBC API, Hibernate API)
        * DAO has Create, GET, UPDATE, and DELETE
    * It is a layer of the API. Persistance layer of API.
    * `ConnectionUtil` is between DAO and DB.
    * DAO creates maintainable code.
    * Controller layer is servlets. `Services` is between DAO and `Controllers`.
    * The **DAO** design pattern is a convention for the creation of the
      presistence layer of a Java application.
    
    * DAO's will create interfaces that define the methods available to the
      service layer. The interfaces will then be implemented by dialect
      specific `impl` classes.

    * This allows for easy switching between dialects without having to 
      change other layers of the applications.

    * Interface defines the **methods** that the **services** will use.
      Allows for easy swapping between database dialects.