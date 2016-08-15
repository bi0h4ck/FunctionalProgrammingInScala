/**
  * Created by diempham on 8/15/16.
  */
/*
* Companion Objects have the same name as the class they represent
* Companion Objects must be in the same file as the class they represent
* Companion Objects have access to their representative's class's private information
* Classes have access to the companion object's private information
 */

class Person(val name: String, private val superheroName: String)

object Person {
  def showMeInnerSecret(x: Person) = x.superheroName
}

object SuperHeroRunner extends App {
  val clark = new Person("Clark Kent", "Superman")
  println(Person.showMeInnerSecret(clark))
}

