/*
* Classes are like blueprints
* val creates accessors, access to the inner state
* var creates mutators, allowing change to inner state
* javap -p is a great utility to see the Java bytecode
 */

/*
* Ancillary constructors look like methods named this
* Primary constructors need to find a way to invoke the primary constructor
* Call another constructor by invoking this (...)
* If an ancillary constructor is multi-lined, the first line must be a call to this (...)
 */

/*
* Named arguments allow calls by constructor parameter name
* Named arguments allow calls in any order
* Default arguments specify default values in the constructor declaration
* In case default arguments are difficult to call, use named arguments to assist
 */

/*
Methods are used in classes and have access to internal state
Methods can also use default and named parameters for added functionality
 */

/*
* Require checks for quality of parameters in a method or constructor
* require will throw an IllegalArgumentException
* try and catch uses pattern matching to determine if a particular Exception is thrown
* Exceptions are thrown with the keyword throw and an Exception object
 */

/*
* extends is a keyword used to subclass a class from another class
* Attributes belonging to super class are sent to the superclass's constructor
* Inheritance must have a "is-a" relationship
* All subclasses are polymorphic, by assignment or method call
* You can have multiple classes in one file
 */

/*
* override keywords is mandatory
* Overridden methods must look the same as the superclass method it is overriding
* Overridden methods are created to change the implementation of the superclass' methods
* Regardless of reference the correct method will be called
 */

/*
* equals test for object equality
* Instead of calling equals you can call ==
* eq is used to test if 2 objects are pointed to the same object
* hashCode is a near unique 32-bit integer that represents the object and used in HashMap, HashSet
* toString is a String representation of the object
 */

/*
* Placing case keyword in front of class makes it a case class
* Case classes have an automatic equals, toString, and hashCode
* You can instantiate a class with the new keyword
* If you don't like the methods created. Override your own.
* You can have automatic pattern matching with case classes
 */

/*
* Abstract classes cannot be instantiated
* Abstract classes have zero or more abstract methods
* Abstract methods don't have implementations
* Any subtype can be assigned to an abstract type reference
 */

/*
* Parameterized Methods can be used in conjunction with Parameterized Classes
* If a type is known at the class level, then it does not need to be declared at the method level
* This only brushes the surface on types and type systems
 */


































