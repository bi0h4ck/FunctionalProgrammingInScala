/*
JAVA getter and JAVA setter
* Use @scala.beans.BeanProperty
* Apply BeanProperty annotation to the property
* If applied to a val, BeanProperty will create a getter
* If applied to a var, BeanProperty will create a setter
 */
import sun.awt.SunToolkit.IllegalThreadException

import scala.beans.BeanProperty


abstract class Person {
  def firstName: String
  def lastName: String
}

class Employee(@BeanProperty val firstName: String,
               @BeanProperty val lastName: String,
               val title: String = "Programmer") extends Person{

  require(firstName.nonEmpty, "First name cannot be empty")
  require(lastName.nonEmpty, "Last name cannot be empty")
  require(title.nonEmpty, "Title cannot be empty")

  if (title.contains("Senior") || title.contains("Junior"))
    throw new IllegalArgumentException("Title cannot contain Junior or Senior")

// scala programmers don't like var

  //Atypical form with side effect without equals
  //def this(firstName: String, lastName: String) {this(firstName, lastName, "Programmer")}
  //                                                println("side effect")}

  //Atypical form without equals
  //def this(firstName: String, lastName: String) {this(firstName, lastName, "Programmer")}

  //Atypical form with side effect
  //def this(firstName: String, lastName: String) = {this(firstName, lastName, "Programmer")
  //                                                 println("Side Effect") }

  //Atypical form
  //def this(firstName: String, lastName: String) = {this(firstName, lastName, "Programmer")}

  //Typical form
  // def this(firstName: String, lastName: String) = this(firstName, lastName, "Programmer")

  def fullName = s"$firstName $lastName"
  //def changeLastName(ln: String) = new Employee(firstName, ln, title)
  def copy(firstName: String = this.firstName, lastName: String = this.lastName, title: String = this.title) = {
    new Employee(firstName, lastName, title)
  }

  override def equals(x: Any): Boolean = {
    if(!x.isInstanceOf[Employee]) false
    else {
      val other = x.asInstanceOf[Employee]
      other.firstName.equals(this.firstName) &&
      other.lastName.equals(this.lastName) &&
      other.title.equals(this.title)
    }
  }

  override def hashCode: Int = {
    var result = 1
    result = 3 * result + firstName.hashCode
    result = 3 * result + lastName.hashCode
    result = 3 * result + title.hashCode
    result
  }

  override def toString = s"Employee($firstName, $lastName, $title)"
}

case class Department(val name: String)

class Manager(firstName: String, lastName: String, title: String, val department: Department) extends
        Employee(firstName, lastName, title) {
  override def fullName = s"$firstName $lastName, ${department.name} Manager"
}
/*
$ javap -p Employee

Compiled from "Employee.scala"
public class Employee {
  private final java.lang.String firstName;
  private java.lang.String lastName;
  public java.lang.String firstName();
  public java.lang.String lastName();
  public void lastName_$eq(java.lang.String);
  public void setLastName(java.lang.String);
  public java.lang.String getFirstName();
  public java.lang.String getLastName();
  public Employee(java.lang.String, java.lang.String);
 */
