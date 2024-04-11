## Spring ##

* **Beans** - objects managed by Spring.
* MVC, Context, Web, Beans are all modules in Spring

* **Projects** - Help build applications. Address concerns beyond dependancy
  injection. Spring Framework is a project. W/O Framework, you cannot have
  any other project. Spring Boot is an important Spring Project. Boot handles
  all other projects easily. 
    * Spring Security
    * Spring web
    * Spring Data
    * Spring cloud

* Projects usually are used w/ Spring Boot.

## Spring Boot ##

* Create standalone production grade applications.
* Spring Boot makes easy to create applications that just run.
* Spring Boot is highly **opinionated**.
* It will use **Tomcat** as webserver.

* Makes decisions about how an app should be designed, structured, configured, 
  what dependencies should be used, etc.

* SPring Boot and other Spring projects like Spring Data, have a mindset of
  **convention** over **configuration**. This means that if what u are doing
  is following best practices, Spring Boot is able to anticipate your needs and
  you do not have to **configure**. 

* Follow Spring Bean naming convention w/o having to configure.

## Benefits & Features of Spring Boot ##

* Provides for **starter dependencies** which are preconfigured and maintained
  dependencies designed to fit Spring Boot's implementations seemlessly
  allowing you to address the standard development issues with standrad 
  frameworks. Such as **Spring Web**. 

* **Spring initializr** is a tool for generating Spring Boot applications w/
  the necessary **starter dependencies** setting up the build config (pom.xml)
  so you dont have to. It will also setup the necessary main method and 
  directory structure.

  ## Spring Starter Projects ##

* **Spring Boot Dev Tools** - Provides additional resources for developers, 
  setting up the DEV environment.
    * **Hot reloading** - Rerun project anytime change is made.

* **Spring Boot Actuator** - Provides additional resources for developers to
  mointor their applications and record data about the application itself. 

## Configuration ##

* **Spring Boot** uses a `.properties` or `.yaml` file called 
  `application.properties/.yaml` for any configuration that needs to be done.
  This will sit in the `src/main/resources` folder. 
    * Spring Boot allows for **profiles** in the `application.properties`,
      whicch can have different configurations per setting and are indicated
      at runtime by passing argument flags. This allows you to configure
      both the `dev`, `local`, and `production` env for app.

* `SpringApplication.run(<main method class>.class, args)` - This method will
  start the application context and the rest of the Spring Boot application.
  It will be called by the generated Main Method. 

* `@SpringBootApplication` - This annotation is above the main method's class's
  declaration. It combines multiple annotations including `@Configuration`, 
  `@EnableAutoConfiguration`,  `@ComponentScan` on the current package.

* `@SpringBootApplication` needs the beans to be in the same package. 

## Spring Web / MVC ##

* Spring Web/MVC are used interchangeably. Spring Web configures Spring MVC.

* **Spring MVC** is a module of Spring Framework that abstracts the servlet 
  layer allowing it to be **dependency injected**. Getting servlets work
  with DI. Follows the Model View Controller design pttern. It is a 
  presentation layer design pattern that splits the presentation logic into
  3 areas of concern.
    * **Models** - Your data objects. 
    * **Views** - These are the displays the end user sees. 
    * **Controllers** - The logic of generating the view from the models data.

* **Spring Web** - Starter dependancy for using Spring MVC in Spring Boot. It
  expands Spring MVC to auto configure everything for the developer based on
  the conventions for creating REST APIs. 

* Spring tools brings Spring Intializer, run DEV tools.

## Spring MVC Annotations ##

* `@Controller` - Stereotype annotation that identifies a class as a Spring
  Bean class in the controller layer. Work with other annotation in Spring Web.
  Label all controller classes with this.

* `@RequestMapping` - Specifies the URL path and HTTP verb handled by a 
  particular method. At the class level this can set the path for all methods
  in that class. 

* There are **sub annotations** for `ResuestMapping` that specify the Verb in
  the annotation itself, e.g., `@GetMapping`, `@PostMapping` etc.

* `@PathVariable` - Annotates a method parameter and associates the value with
  a path parameter from the URL. The mapping for the method must contain the
  path variable name in curly braces. E.g., `@GetMapping("/{id}")`.

* `@ResponseBody` - This will ensure that the response of the method returns
  any information for the body as JSON. At the class level it will apply to
  all methods of that class.

* `@RestController` - This is a combination annotation that combines 
  `@Controller` and `@ResponseBody`.

* `@RequestBody` - Converts the JSON body of the request to a Java object as the
  method param. 

## Spring Web Beans ##

* DispatcherServlet (Servlet Object) - This is SpringMVC's FrontController
  servlet. Front Controller is a design pattern where there is a single entry
  point for all requests that then get router to individual handlers/controllers

* **HandlerMapping** - This interface works with the DispatherServlet to route 
  the requests to the proper controller classes and methods. The default 
  implemettation of handler mapping is the RequestMappingHandlerMapping.

* **ViewResolver** - This helps build the view if one is returned from a 
  controller method. If a controller method returns a String, the VR will 
  attempt to find a static file that matches that String in order to return 
  as the body of the response. REST does not return views and so a REST API or
  RestController does not utilize the VR. 

* **ContextLoaderListener** - This bean ties together the Servlet lifecycle 
  (of the dispatcherServlet) with the lifecycle of the ApplicationContext. 

* Controller are NOT servlets, they are Spring Beans.

* Controllers, services, and repos are handled by developers.