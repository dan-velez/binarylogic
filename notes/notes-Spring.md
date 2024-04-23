# CarShow #

Demo application for Spring Boot.

## Bottom -> Up Development ##

* Develop the classes in this order:
    * `@Entity`
    * `@Repository`


## Questions ##

* When do we use `@Autowired`? Arent the classes found automatically? Do we use
  it on Controllers? Services? 

* Why did we add extra controller methods if they are included already when
  they are generated?


## Notes ##

* An entity class is a simple Java class that is annotated with JPA's @Entity 
  annotation.Entity classes use the standard JavaBean naming convention and have 
  proper getter and setter methods. The class fields have private visibility.

* Entities represent Models.

* JPA Creates a database table for each `@Entity` that is component scans.

* The fields of an `Entity` represent **columns** in the table.

* **ORM** is a technique that allows OOP style in a database. It is independant
  of databases. **Hibernate** is a **JPA** implementation for Java.

* `@Service`, `@Repository`, and `@Controller` are **DI** annotations in Spring.
  They are injected using `@AutoWired`.

* `CrudRepository` Methods:
    * `count()`
    * `findAll()`
    * `findById(ID Id)`
    * `delete(T entity)`
    * `deleteAll()`
    * `save(S entity)`
    * `saveAll(Iterable<S> entities)`

* `CommandLineRunner` allows us to execute additional code before the app is
   started. The main class of Spring Boot app implements `CommandLineRunner`.

* **JPA Fetch Type**
    * **Eager** - Related entities are loaded when fetching.
    * **Lazy** - Related entities are NOT loaded. 
```java
University university = repository.findById(1L);

// The students collection is not loaded yet
System.out.println(university.getName());

// The students collection is loaded when you access it
for (Student student : university.getStudents()) {
    System.out.println(student.getName());
}
```

* Use `@ManyToOne` annotation to define relationships in tables. Recommended to
  use the `fetchType.LAZY` for associations. 

* `cascade` defines how cascading affects the entities in **deletions** or
  **updates**. `ALL` means all operations are cascaded. If the owner is deleted,
  the cars linked to the owner are deleted as well. The `mappedBy` setting tells
  us the **foreign key** relation.

* For `@ManyToMany` it is recommended to use a `Set` in **Hibernate**.

* ORM is a technique to use OOP in datbases.
* JPA is an ORM specification.
* Hibernate is an implementation of JPA.

* Create entity class using `@Entity` annotation of JPA.
* CrudRepostory is extended.
* CrudRepo provides methods for CRUD on the database.
* Add demo data using CommandLineRunner interface.
* Connect to MySQL using application.properties file.

* **RESTFul** web service is created in the `controller` class.
* In **Spring Boot**, all HTTP requests are handled by controller class.

* **Spring REST** finds all public `repositories` from the application
  and creates **RESTful** web services for `entities`.

* Spring Data REST returns JSON data in Hypertext Application Language.
* **HAL** - Makes RESTful web services easier for frontend devs.

* **Service** layers facilitates communication between `controllers` and
  `persistence`. It also houses the **business logic** like **validation**


* **ResponseEntity** represents an HTTP response. `ResponseBody` puts
  the return value into the body of the response.

* `@PathVariable` is used to pass data between the client and server. They
  are part of the **URL path**.
    `http://example.com/user/123`

* `@RequestBody` annotation maps HttpRequest body to a transfer or domain
  object, enabling automatic deserialization. Spring deserializes the
  JSON into a Java type.

* `@ResponseBody` annotation tells controller that the object returned
  is serialized into JSON and passed back into the HttpResponse object.

* **Spring Web** is used to write REST endpoints.

* The entry point of the Spring Boot Application is the class contains 
  `@SpringBootApplication` annotation.

* Spring Boot application scans all the beans and package declarations
  when the application initializes. 

*  

## Spring Security ##

* A Spring project focued on securing to industry standards, particularly web
  apps. Integrates with Spring Boot easily with **Spring Security Starter**
  dependency and it is designed to work with **Spring Web**.

* One vulnerability will make apps insecure.

* Spring security by default will lock down everything in application and
  exposure needs to be configured. Without configuration, no one can use
  application. **WHAT is exposed to WHO**.

* Spring security can be frustrating to **debug**. Exception messages are
  vague to protect **sensitive data**. No info about objects or what the app
  design is like.

* **Actuator** creates health endpoints for **monitoring**. 

* Spring uses **servlets**, **jackson.xml**, **JDBC**. 

* Spring security is constantly under development for new threats. Documentation
  lags with updates. 

* **Authentication Manager** - Primary bean that sets up the secutiy for the 
  env. you str eeorking on. Base secutiry configutaions. Validate and authorize
  users. 

* **Security Context** - Current users and ensures info is available throughout
  app. 

* **Authenication Provider** - Implementation of actual auth process. Many types
  of providers. JWT, OAuth, etc..

* **UserDetailsService** - Bean for accessing user infomation from the data
  source.

* **Authorization** - Makee choice to what access user has.

* Authentication managers uses the provider which implements the auth logic.
* Validate username and password using UserDetailsService. 

* **Authentication** - Proving user/client is who they claim to be.
* **Authorization** - Ensuring the authenticated individual has proper access.


## 04/22/24 ##
* **JWT** -> Server responds w/ cookie. JWT remembers user and what level of
  authorization they have. Dont need login everytime make a request.
  Constructed differently in every situation. What info goes into JWT is
  different everytime. Use instructions on CarShow project. 