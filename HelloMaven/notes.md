## Maven Notes ##
* **pom.xml** - Project Object Model.

* Maven goal **archetype:generate**.
* The prefix archetype is the **plugin** that provides the **goal**.

* This **archetype:generate** goal created a simple project based upon a 
  **maven-archetype-quickstart** archetype

* A **plugin** is a **collection of goals** with a general common purpose.

* Command **mvn package** is a **phase**.
* A phase is a step in the **build lifecycle**.

* When a phase is given, Maven executes **every phase in the sequence** up to 
  and  including the one defined.

* 