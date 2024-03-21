# Notes 03-19-2024  Binary Logic #

* **Three layer architecture**:

    * **Presentation Layer**: Controller layer. Present info to user and taking
      user info. Layers are packages in Java application. Showing outputs.

    * **Service Layer**: This is the business logic of app. Manipulating objects
      and other logical functions that need to be performed are done in this
      layer. E.g. withdraw balance from bank account. Pass data to persistance.

    * **Persistance Layer**: Generally called repositories or DAO (data access
      objects). This is concerned with storage of data, usually in a database.