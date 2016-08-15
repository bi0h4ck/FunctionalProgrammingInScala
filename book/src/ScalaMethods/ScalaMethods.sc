def add(x: Int, y: Int) = x + y
def sub(x: Double, y: Double) = x - y

add(4, 9) //res0: Int = 13
println(add(sub(45, 5).round.toInt, sub(3, 78).round.toInt)) //
//-35
//res1: Unit = ()

/*
* Any is the utmost super type and is the parent of everything
* AnyVal is the parent of the primitive types
* AnyRef is the same as java.lang.Object in Java
* AnyRef is the parent of all classes written in Java and Scala
 */

/*
* Methods are defined using def
* Methods are not functions
* Last evaluated statement will be returned
* Most of the time you can omit the return type
 */
def numberStatus(a: Int) =
  if (a < 10) "Less than 10"
  else if (a > 10) "Greater than 10"
  else "It is 10!"

numberStatus(7) //res2: String = Less than 10


/*
* Unit doesn't give you anything
* Analogous to Java's void
* Unit is actually an object
* Unit's full type name is scala.Unit
* Unit has one value: ()
* Whenever you see () that is a Unit
 */

/*
* Recursive methods call themselves
* Recursive methods require return type signature
* Recursive methods can either be infinite
* Recursive methods can terminate on a base case
* Recursive methods have a limited stack space
 */

def factorial(n: BigInt): BigInt = {
  if ( n == 0 || n == 1) 1
  else n * factorial(n - 1)
}

factorial(6) //res3: BigInt = 720

/*
* Recursive methods may run out of stack memory
* Convert recursive method into a tail recursive method
* Tail recursive methods after evaluation must be returned
* Use @scala.annotation.tail rec for compilation assistance
 */
import scala.annotation.tailrec


def fact(n: BigInt, acc: BigInt): BigInt = {
  if (n == 0 || n == 1) acc
  else fact(n - 1, acc * n)
}

def factorial2(n: Int) = fact(n, 1) //720 res4: Unit = ()



println(factorial2(6))


/*
* Methods can be hidden inside another method
* The outside method has exclusive access to the inner method
 */
def factorial3(n: Int) = {
  @tailrec
  def fact(n: BigInt, acc: BigInt): BigInt = {
    if (n == 0 || n == 1) acc
    else fact(n - 1, acc * n)
  }
  fact(n, 1)
}

/*
* Method can have spaces, and other valid identifier characters, including
OpChars if surrounded by a backtick
*/
def `Summation of` (x: Int, y: Int) = x + y

`Summation of`(3, 4) //res5: Int = 7

/*
* Methods may be referenced without a backtick if they are not reserved.
Otherwise you will need to include backticks
* Any method without a backtick, can include an OpChar if followed by an underscore
 */

def whatever_? = true

/*
* Operator Overloading is using operators as method names
* Do not abuse the power
* Operator Overloading will interpret the name into $name or $unicode
* You have been using operator overloading perhaps without realizing it.
 */

/*
* Method overloading is reuse of the same method name
* Method parameters must be different
 */
def addNum(x: Int) = x + 2
def addNum(x: Double) = x + 10.0
def addNum(x: String) = x + 5

println(addNum("woo woo ")) //woo woo 5 res6: Unit = ()
println(addNum(20)) //22 res7: Unit = ()
println(addNum(15.0)) //25.0 res8: Unit = ()

def addTen(x: Int): Int = x + 10
def addTen(x: Double): Double = x + 14.0

println(addTen(15)) // 25 res9: Unit = ()



/*
* Named arguments allow calls by method parameter name
* Named arguments allow calls in any order
* Default Arguments specify default values in the method declaration
* In case default arguments are difficult to call, use named arguments to assist
 */


def processNumbers(b: Boolean = true, x: Int, y: Int) = if (b) x else y
println(processNumbers(x = 5, y = 4))

def addStr(a: String, b: String = "man") = a + b
println(addStr("Hello ", "world!")) // Hello world! res11: Unit = ()
println(addStr("Hey ")) // Hey man res12: Unit = ()


/*
* isInstanceOf will return Boolean whether object is an instance of a type
* asInstanceOf will convert object to a certain type
* asInstanceOf will require that object is convertible to a type
* Misuse of asInstanceOf will result in a ClassCastException
 */

val g: Any = "woo woo"
val h: String = g.asInstanceOf[String]

def decide(x: Any) = if(x.isInstanceOf[Int]) x.asInstanceOf[Int] + 1 else -1

println(decide(7)) // 8 res13: Unit = ()
println(decide(1.0)) // -1 res14: Unit = ()

/*
* Parameterized Types maintain type consistency
* Parameterized Types use []
* Parameterized Types are nearly equivalent to Java generics
* Parameterized Types are nearly equivalent to C++ templates
* Prefer use of single letters: A, B, C, D, E, T
 */

def decide2[T](b: Boolean, x: T, y: T): T = if (b) x else y

def getNextChar(c: Char) = (c + 1).toChar
println(getNextChar(decide2(true, 'r', 'd')))   //s res15: Unit = ()












