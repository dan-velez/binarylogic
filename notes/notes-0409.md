## 4 PIllars Of OOP ##

* There are 4 pillars believed to be essential to OOP. There is lots of
  debate surrounding this topic. such as How many pillars are there?
  What qualifies? Do they exist? How are they diff in OOP from other
  paradigms? Etc.. 

### Abstraction ###

Concept of abstraction is that details are not required to be known in order
to use the functionalities provided. The classic example is driving a car
where you need only know the input.

Covariance - the ability for java to treat child object as if it were an
instance of its parent class or interface.

## Spring ##

* Dependancy injection is the base of the framework.
* Spring boot makes design decisions for you. How to handle requests, DB, 
  security. Best practices for common Java usage. 

* Spring is a braod topic. It is an **ecosystem** of tools (framework) that are
  used for building applications quickly and to industry standards. 

* A lot of tools in **Spring**. Spring Framework, Spring Data, Spring MVC,
  Spring Secutiry, Spring Boot. Spring's core functionality is based on 
  **Dependancy injection** or **inversion of control**. 

* Dependancy injection is a **design pattern**. Concepts vs design patterns.
* Dependancy Injection (DI):
    * DI (inversion of control: IoC) is an architectual design pattern that
      decouples the various layers of the application allowing for object
      dependencies to be determined at runtime instead of compile time. 

* **Object level dependencies** are when objec'ts methods are dependant on
  having access to the functionalities of another object. Clssic examples
  include a **service layer** object requiring a **dao** object in order to
  run its methods. **Angular** uses DI also.

* Types:
    * **Contructor injection**: The dependant object is determined when the
      constructor for the managed object is called. The dependancy is passed
      as a parameter into the constructor. This is an option in Spring and
      the only type of injection in **Angular**. This is considered the
      safest, best practice in Spring. Dependnacy is created at start.

    * **Setter Injection**: The dependant object is fulfilled via a setter
      filling the field shortly after object instantiation. This does provide
      a short window of time where the dependant object field is null but may
      be necessary if you have objects with cycilar dependencies. Spring can
      do this. 

    * **Interface Injection**: Uses interfaces to set the dependant object. 
      This is not possible in Spring. 

    * **Field Injection**: The dependant field is filled at some point shortly
      after instantiation directly without using code defined by the developer.
      In Spring this is done with the **Reflection API**. Allows to change
      classes at runtime. Breaks encapsulation. Set private variables, change
      modifiers, but it is useful for frameworks. Considered poor practice. 
      Highly recommended not to use it.

## Spring Framework ##

This is the core framework of Spring ecosystem. All other Spring projects and
modules will require the full Spring Framework in order to be used. Its primary
focus is on DI. Can be used for things outside of web development. It is used
anywhere DI can be used. **VMWare** designed Spring. 

* Spring framework is made up of modules. Some of these are required and some
  are optional.

    * **Core**: Required. Mandatory functionality of the framework. 
    
    * **Beans**: Required. Funtionality around the handling/managing of 
      **Spring Beans**. Any object that is being handled by Spring is a bean.
      not the same as **Java Beans** (design pattern for models). Spring apps
      have 100s of beans. 
    
    * **Context**: Required for modern applications. Functionality revolving
      around **annotations** and the **Aplication Context**.

    * **SpringAOP**: Required for Context module. Functionality around Spring's
      **Aspect Oriented Programming** framework. 

    * **SpringORM**: Optional. This is used to integrate an ORM framework
      like **Hibernate** with Spring. Used to abstract some ofthe data 
      persistence layer of an application. 

    * **SpringMVC**: Optional. Functionality around handling HTTP requests in
      Spring. It abstracts **Servlets** for the developer. 

* Sprin projects are self contained frameworks built on top of Spring Framework
  that adress additional concerns beyond DI.

    * **SpringWeb** - A framework for handling HTTP comm to and froma a built in
      web server. 

    * **SpringBoot** - A framework for creating **Enterprise Level** production
      ready Java applications "at the push of a button". Preconfigured,
      predesigned application, that runs. Add custom code to solve your 
      business problem. All boilerplate coding is done. Dont need to edit
      **XML** files. 95% of Java web development is **Spring Boot**. 

    * **SpringDataJPA** - Highly abstract the ORM, allowing for developer to
      work in enirely OOP context instead of context switching to a RDBMS
      system. Just setup models. Buils tables for you. No SQL queries.

* Spring Framework was developed by Rod Johnson in 2002.

* **Bean Wiring** - Regestering a class with Spring. With XML, configuration 
  class, or **annotations**. Use XML if it is a class from external library.

* Spring is creating the classes. This is inversion of control.

## Spring Beans ##

* Objects that are managed by Spring Framework. These are the objects that are
  being injected, or injected into.

* Beans that are constructed by the framework are "held" (monitored, managed) in
  the Spring (IoC) Container.

* Connecting beans together is called Bean Wiring and can be done in 3 major
  ways:
    * XML configuration
    * A configuration class with Bean declarations.
    * Component scanning with Stereotype Annotations.

* Allowing the framework to make the decision on which beans are provided for
  which dependency is called "Autowiring".

## Bean Lifecycle ##

* Managed by Spring.
* Spring identifies that a Bean is necessary and prepares to call the 
  constructor.
* The SPring container creates the Bean with the BeanFactory. Calling the
  constructor with any necessary dependencies. 

* PostProcessing occures, setting the Bean name and metadata. 
* Custom initialization method is run.
* PostProcessing finishes and the Bean is available for use in the container.
* Container will recognize when the Bean is no longer needed.
* PreDestory custom method will be run.
* Spring deconstruction method will be run.
* The object will be available for garbage collection.

* Spring/IoC Container:
    * This is the object that manages the beans through their entire LC.
    * There are 2 options for the type of container: A Spring APplication
      will use: **Factory**, and **ApplicationContext**. On

* Stereotype Annotations:
    All function the exact same way. They indicate to other developers and
    other frameworks the layer of the application that the bean's class is
    a part of allowing for developers to better understand the intent of the
    class. 

* `@Component` is the general (sometimes called parent) annotation that gives no
  other context beyond the class is to be instantiated as a bean with component
  scanning. The others indicate layer as well: `@Controller`, `@Service`, 
  `@Repository`.

* The functionality of all 4 annotations is to register the bean with the Spring
  container via component scanning. 

## Bean Scopes ##

* Bean scopes declare how many beans of a class will exist in the Spring 
  Container at a time. They can be set via the xml configuration with a tag
  or on the @Bean annotation or a sterotype with the scope attribute. 

* There are 2 scopes defined for the base Spring framework and another 4 
  provided by SpringMVC called the "web aware" scopes. The web aware scopes 
  were slightly modified in Spring 5 leading to a depreciated scope.

* **Universal**:
    * **Singleton** (default) - There is only one bean of each class at a time
      in the Spring container.
    
    * **Prototype** - This creates a new Bean for each instance where the Bean
      is requested from the Container.

* **Web Aware Scopes**:
    * **Request**: Makes a new Bean to handle each request that comes into the
      application.

    * **Session** - For each servlet session, a set of Beans will be created.
      Sessions allow you to track clients associating the same beans with the
      same client requests. This breaks the statelessness constraint of REST.

    * **Aplication Scope**: One set of beans per ServletContext. THere is one
      servlet context in the application. 

    * **Websockets** - One set of beans per websocket. We will not be using 
      websockets.

* **Deprecated**:
    * **Global Sessions** - Web aware pre Spring 5. Used with portlets which
      are not in use. Like websockets. 