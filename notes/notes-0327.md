# Testing #

* Testing application logic and functionality is a hugr part of modern dev.

* Ensuring the reliability of the application is critical to maintaining
  the application.

* While **manual testing** (testing by building the app and then having a person
  interact with it to find bugs) is still done; automation testing is the
  expected form for the majority of testing in a software dev environment.

* There are various levels of testing:
    
    * **Unit Testing**: This tests the smallest unit of runnable code in an
      application. These are generally methods in Java.

    * **Integration Testing**: This fouses on the interaction between 
      application layers. Test across multiple methods in Java from controller
      layer to the DAO layer for instance. Also connections between the 
      **backend** and **frontend**, or **backend** and **db**.

    * **End-to-End (E2E)**: Will test information flow from the **frontend** to
      **backend** and reverse to ensure entire application flow is functioning.

    * **User Acceptance Testing (UAT)**: Tests that ensure that the app is
      usable by **end-user**.  

* All of the above can be done manually or w/ automation. Generally howver, 
  developers are expected to write their own **unit tests** and maybe some basic
  **integration tests** with an **automation framework**.

* **Test Driven Development (TDD)**: Focuses on writing tests first and then 
  designing code to match the test cases provided. This can be a very efficient
  way to keep **good coding practices** and focus development saving time when
  done effectively.

* **Positive and negative testing**: 
    * Positive tests are tests that ensure the code works in the ideal scenario.
    * Negative tests are testst that ensure the code is durable enough to handle
      unexpected inputs. (uncaught **NullPointerException**).

* **Edge Cases**: These are uncommon but possible situations that need to be
  accounted for when programming and therefore should be tested. Examples are
  essentially large numbers, small numbers, 0, null, etc...


## JUnit ##

* A **unit testing** framework for Java. Provides for automated running of
 automated unit tests and possibly some integration tests and the tools
 necessary to create them.

* **JUnit** is integrated into all the common **Java IDEs** and can be included
  as a **maven** dependancy and run by maven during its **testing phase**.

* JUnit uses **annotations** to indicate what tests should be run and what 
  methods need to run and when to set up the **testing context** (this is also 
  called the **test bed**).

* JUnit 5 **annotations** - please note, JUNit significantly changed their
  annotations from **v4 to v5**. If u encounter JUnit using a different
  annotation names, they generally do the same thing, but you will need to look
  up name conversion in docs.

* `@Test` - Indicates a test method that needs to be run by JUnit. A test method
  will need an assertion statement to determine if the test passed or failed.

* `@Ignore` - This can be added with `@Test` to ignore the test when the
  suite runs. This is used generally to deactivate a failing test to see
  if there are wider problems or if the issue is localized to the specific
  test.

* `@BeforeAll` - This goes above a static method and will run once before
  all the tests in that calss are run.

* `@BeforeEach` - indicates a method that should be run each time before
    a test in that class is run.

* `@AfterEach/@AfterAll` - Works the same as their before counterparts
  but happen after the tests/tests run.

* **Assert methods** - JUnit provides methods for determining if a test succeeds
  or fails. These methods assert the intended outcome and test it against the 
  actual outcome. Thus they will all result in a boolean. pass/fail true/false.

    * `.assertTrue (boolean)` - Indicates the expected output is true.
    * `.assertFalse (boolean)` - Indicates expected output is false.
    * `assertEquals (result, expected)` - Tests the equality of the result to 
      the expected outcome.
    * `assertNotEquals (result, expected)` - Tests equality.
    * `assertThat ()` - Write own custom assertion logic.
    * `assertThrows (exception type, lambda)` - Tests an expception is produced 
      when code is run. requires a **lambda statement** (inline anonymous 
      function), that can be easily wrapped in a `try/catch` block by **JUnit**.

* `static import` - includes methods as if they were methods of the class 
  itself. Imports static methods.


## HTTP ##

* Used in Spring MVC part of the course.
* The internet is a publicly accessible network of networks connected via nodes
  that allow data to travel from one machine to another.

* Modems used telephone connections. Call house to connect to their PC. BBS
  systems. Call to recieve information from PC to telephone number. 

* IP addresses connects all computers together. Network addresses connected
  PCs instead of "calling" other PCs with phone numbers.

* Nodes and packets.

* The primary protocol for data transfer accross the internet is **HTTP**:
  **Hyper Text Transfer Protocol**.  Browser uses HTTP.

* HTTP is made up of requests and responses. A client will send a request 
  generally to a server. The server will then process the request and return
  a response.

* An **http request** is made up of 4 major parts:
    
    * **Method/Verb** - This is used to indicate to the recipient the type of 
      request that is being sent. GET/POST/PUT/DELETE. For instance, browsers
      send **GET** requests to get **HTML** pages when loading a page.
    
    * **Location (URL/IP address)** - Where request is going.

    * **Headers** - Metadata about the request. **Cookies** are in the header.
      Cookies are used to identify **requester**.

    * **Body** - Contains any information the server will require to fulfill the
      request.

* Note: the body is **encrypted** when using **https**.

* **HTTP Response**:
    * **Header** - `application/json` for REST APIs.

    * **Body** - Contains any information requested. This would be the `HTML`
      when requesting a **webpage**. 
    
    * **Status Code** - This is an indicator of the result of the request,
     **success**, **failure**, or **other**...

* **Status Codes** - 5 levels. Each level gives meaning. Each code has a 
  specific meaning. 
    
    * **1xx**: Informational.
        * **101**: Switching protocols.

    * **2xx**: Success.
        * **200**: OK
        * **201**: Created
        * **202**: Accepted
        * **204**: No Content
    
    * **3x**: Redirects.
        * **301**: Moved Permenantly
        * **307**: Temporary Redirect
    
    * **4xx**: Client Side Error.
        * **400**: Bad Request
        * **401**: Unauthorized
        * **403**: Forbidden
        * **404**: Not Found
        * **418**: I'm a teapot - Request is using server incorrectly.
        * **420**: Enhance your Calm - (twitter specific) Too many requests
          in a limited time.

    * **5xx**: Serverside Error
        * **500**: Internal Server Error
        * **501**: Not Implemented
        * **502**: Bad Gateway
        * **504**: Gateway Timeout

* **HTTP Verbs** (REST Conventions)

    * **GET** - This is used to request information from server. Rarely contains
      information in the body.

    * **POST** - Sends new infomation to the server usually to be persisted.
      Register new user, login.

    * **PUT** - Update an entire object/resource on the server.

    * **PATCH** - Update a specific part of an object resource on the server.
      Was not part of HTTP 1.0 protocol, thus many libs or frameworks will
      not include it by default in their structures.

    * **DELETE** - Removes an object or resource from the server.
    
    *  **TRACE** - Tracks a path through the internet that the request takes to
      the server.

    * **HEAD** - Returns the header of the request. Used for debugging.

    * **OPTIONS** - Returns the acceptable protocols for comm w/ server.

* **Servlet** - Java Object that is designed to handle internet based comm. 
  usually HTTP, but can handle other protocols. They can recieve/handle
  requests and send responses. Do not create requests.

* **Servlets** require a **web server application** to run. They are build into
  **web archives (war files)**. Used by Spring MVC. **WAR** files are hosted
  by web server. We will use **tomcat**.

* Web servers are designed to continuously run using programs that **listen**
  at a **localtion** and **port** for comm, generally HTTP requests to come
  in to the application. **Servlet** handles logic of how to **respond**. 
  **Tomcat** uses **PORT 8080** by default for its listening port.

* **Webapp folder**: The web-server application folder is the standard folder
  that web servers/web-containers will look for in a **WAR** project for
  configuration and static files like **HTML** files to host. Configuring
  what servlets to use at which endpoints will be done in the 
  **Deployment Descriptor** in the webapp folder. For servlets, the DD is the
  **web.xml** file.

* Servlets generally stay in `controller` layer.

## REST ## 

* Repsresentational state transfer. An architectual convention for building
  web based applications. It defined servers as collections of resources that
  can be utilized by client applications. Keeps these resources at endpoints (
    locations).

* Competitor originally to `SOAP`. 
* There are 6 pillars, constraints, etc. of REST:
    
    * **Client-server architecture**.

    * **Stateless**: Each request must contain all the information from the client
      for the server to fulfill the request. This makes Authorization a bit 
      tricky at times. Server stores auth info and client uses small piece of
      data to remember who sent request. Requests are independant of each other.

    * **Cacheable**: Store information that need to access repetitively. Store 
      locally. Since repsonses only contain resources, resources can be cached
      and duplicate requests are unnecessary. 

    * **UNiform interface**: The sys architecture should be designed in a uniform
      manner allowing for the easy assumption of where related resources are
      available. Conventionally this is implemented via URL paths going from
      collective resources to more specific resources.
        
        * `www.website.com/app` - base URL
        * `www.wesbite.com/app/toys` - collective resource of all toy categories.
        * `www.website.com/app/toys/dolls` - collective res of all dolls.
        * `www.website.com/app/toys/dolls/1` - singular resource w id of 1.
    
    * **Layered-Architecture**: The server should use the layered arch pattern.
      So the client needs only to be aware of the user interaction layer and no
      knowledge of the logic or persistance layers is necessary.

    * **(Optional) Code on Demand**: This allows functionality to be expanded
      by providing the client executable code that they can use to interact
      with the resources. This is not well defined, or aggreed upon in practice.
      `Applets`. 

* Able to have clients on different programming languages.

* **REST Resources**
    
    *  A **resource** is defined in REST as any type of raw data that the server
      provides. However, resources should not indicate any information about
      how that data should be used/displayed.

    * Servlets originally reuturned entire HTML pages. REST does not return 
      views, returns language-agnostic data. 
      
    * A REST resource must be in language agnostic form. The most common
      form for a resource for a resource in RESTful app is **JSON**.

    * **XML** has been used in the past traditionally.

    * `pokeapi.co` to learn about REST.

    * REST requires that all resources have a unique identifier and therefore
      the locaton that they can be accessed at. 

    * Can have same resources for diff URLS.

    * The **state** of a resource at any given moment is the "resource 
      representation". So when a resource is updated, it's considered the same
      resource but its representation has changed.

    * **Safe and idempotent verbs**
        * REST recognizes categories of its HTTP verbs based on their 
          conventional usage. 
        
        * These categories are not exculsive of each other or entirely inclusive
          of all HTTP verbs.

        * Safe verbs are verbs that do not make any change to the state of the
          server when they are executed.
            * GET, OPTION, TRACE, HEAD are all safe.

        * **Idempotent** verbs are verbs that if u send the exact same request
          multiple times, the state of the DB will only change the first time a 
          request is sent and will not be changed in subsequent requests.
        * The response should always be the same for each duplicate request as 
          well. 
            * DELETE , GET, PUT, OPTION, PATCH, HEAD, 
                * TRACE is not considered idempontent bcause the request a path
                  can take is not stable. Different requests may take different
                  paths through the internet to reach the same server.

        * **HATEOAS** - Hypermedia As the Engine Of Application State.
            * The idea in REST that a server should maintain a client server
              relationship where each time a resource is requested, the server
              shares to the client more information about what resources are
              available. This is generally done through hypermedia links since
              that is how locations of resources are defined.

              * Peek form of RESTfulness.

## JSON ##
* JAckson databind is library for JSON. 