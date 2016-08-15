/**
  * Created by diempham on 8/15/16.
  */
/*
*Objects are singletons
*Objects are Scala's replacement for the key word static
*Objects are meant for factories, defining pattern matching, defining defaults, and main methods
*Main methods are always inside of objects
* You can forgo the main declaration by having your object extend App
 */
object MyObject {
  def foo(x: Int, y: Int) = x + y
}

println(MyObject.foo(3, 7)) //10


/*
Classes
* Need to define a template to create multiple instances
* Every instance is in charge of it's own state
 */
class Employee(val firstName: String, val lastName: String, val title: String)


/*
Objects
* Need a singleton
* Need a factory pattern
* Need to implement pattern matching logic
* Need a utility method that doesn't require an instance or state
* Need default values
* Need a main method
 */

object Katy extends Employee("Katy", "Perry", "Singer")
println(Katy.firstName) //Katy
println(Katy.lastName) //Perry
println(Katy.title) //Singer