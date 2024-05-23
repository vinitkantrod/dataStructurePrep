## Factory Method

-------------------------

Intent:
1. Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
2. Defining a "virtual" constructor.
3. The `new` operator is considered harmful.

------------------------------------
#### The Factory Method defines an interface for creating objects, but lets subclasses decide which classes to instantiate.

------------------------------------
### When To use?
1. There should be set of classes which implement common interface.
2. You don't know which object to create (you know which object to create only at run time)
3. Object initialization is somewhat expensive.
4. Factory method act as an actual factory. It creates our products which we request but we don’t need to aware of how they are created.

--------------------------

### Example
Create account at bank.
Accounts could be of 3 types (PersonalAcc, BusinessAcc, CheckingAcc)
Accounts could be open at local branch or foreign branch

### Discussion

1. Factory Method is to creating objects as Template Method is to implementing an algorithm. A superclass specifies all standard and generic behavior (using pure virtual "placeholders" for creation steps), and then delegates the creation details to subclasses that are supplied by the client.
2. Factory Method makes a design more customizable and only a little more complicated. Other design patterns require new classes, whereas Factory Method only requires a new operation.
3. Factory Method is similar to Abstract Factory but without the emphasis on families. 
4. Factory Methods are routinely specified by an architectural framework, and then implemented by the user of the framework. 
5. Factory Methods are usually called within Template Methods. 
6. Factory Method: creation through inheritance. Prototype: creation through delegation. 
7. Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as the designer discovers where more flexibility is needed.
8. Prototype doesn't require subclassing, but it does require an Initialize operation. Factory Method requires subclassing, but doesn't require Initialize. 
9. The advantage of a Factory Method is that it can return the same instance multiple times, or can return a subclass rather than an object of that exact type.

10. Some Factory Method advocates recommend that as a matter of language design (or failing that, as a matter of style) absolutely all constructors should be private or protected. It's no one else's business whether a class manufactures a new object or recycles an old one.
   
11. The `new` operator considered harmful. There is a difference between requesting an object and creating one. The new operator always creates an object, and fails to encapsulate object creation. A Factory Method enforces that encapsulation, and allows an object to be requested without inextricable coupling to the act of creation.