val julie = new Employee("Julie", "Love")
println(julie.firstName) //Julie
println(julie.lastName) //Love

//val newJulie = julie.changeLastName("Hunt")
val newJulie = julie.copy(lastName = "Hunt")
println(newJulie.lastName) //Hunt

println(newJulie.title) //Programmer
println(newJulie.fullName) //Julie Hunt

val lulu = new Employee(lastName = "Pupu", firstName = "Lulu")
println(s"The first name is ${lulu.firstName}") //The first name is Lulu
println(s"The last name is ${lulu.lastName}") //The last name is Pupu
println(lulu.fullName) //Lulu Pupu

try {
  new Employee("Weiwei", "Wang", "Senior software developer")
} catch {
  case iae: IllegalArgumentException => println(iae.getMessage)
} finally {
  println("Continuing with our program")
}
//Title cannot contain Junior or Senior
//Continuing with our program

val mathematics = new Department("Mathematics")
val nick = new Manager("Nick", "Alala", "Mathematician, Logician", mathematics)
println(nick.fullName) //Nick Alala, Mathematics Manager
println(nick.title) //Mathematician, Logician
println(nick.department.name) //Mathematics

val nickEmployee: Employee = nick
println(nickEmployee.fullName) //Nick Alala, Mathematics Manager

def extractFirstName(e: Employee) = e.firstName
println(extractFirstName(nick)) //Nick

val anotherJulie = new Employee("Julie", "Hunt", "Programmer")
println(anotherJulie.equals(newJulie)) //true
println(newJulie eq anotherJulie) //false

val evenAnotherJulie = anotherJulie
println(anotherJulie eq evenAnotherJulie) //true
//println(newJulie.hashCode == anotherJulie.hashCode) //true
println(anotherJulie.hashCode == evenAnotherJulie.hashCode) //true
//println(julie.hashCode != anotherJulie.hashCode) //true

println(evenAnotherJulie.toString) //Employee(Julie, Hunt, Programmer)

val toys = Department("Toys")
println(toys) //Department(Toys)
val toys2 = Department("Toys")
println(toys == toys2) //true
println(toys.hashCode() == toys2.hashCode()) //true
val hardware = toys.copy(name = "Hardware")
println(hardware) //Department(Hardware)

val name = toys match {
  case Department(n) => n
  case _ => "Unknown"
}
println(name) //Toys

val Department(name2) = toys
println(name2) //Toys


// Manager extends from Employee extends from Person, so nick: Manager can be assigned to nickPerson: Person
val nickPerson: Person = nick






















