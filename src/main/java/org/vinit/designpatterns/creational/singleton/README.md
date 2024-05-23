### Singleton Design Pattern

-----------------------------

A java singleton class is a class that can only one objects. After first time, if we try to instantiate the class then the new object will point to the first instance created.

#### Key points.
1. Make the constructor private
2. Write static method that returns the object of singleton class. here concept of lazy initialization is used.
3. The primary purpose of a java Singleton class is to restrict the limit of the number of object creations to only one. This often ensures that there is access control to resources, for example, socket or database connection.

4. Memory space wastage does not occur with the use of the singleton class because it restricts instance creation. As the object creation will take place only once instead of creating it each time a new request is made.
