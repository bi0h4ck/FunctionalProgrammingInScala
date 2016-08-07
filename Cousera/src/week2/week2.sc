def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop (a + 1, f(a) + acc)
  }
  loop(a, 0)
}
sum(x => x * x)(3, 5)



//Functions returning functions
def sumf(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

//Stepwise applications
def sumInts = sumf(x => x)
def sumCubes = sumf(x => x * x * x)
sumCubes(2, 3)
//def sumFactorials = sumf(fact)


//multiple parameter list
def sum1(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)

sum1(x => x * x)(3, 5)


def product(f: Int  => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
product(x => x * x)(3, 4)

def fact(n: Int) = product(x => x)(1, n)
fact(3)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))



def product1(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
product1(x => x * x)(3, 4)


//Example: Finding fixed points
import math.abs
val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}
fixedPoint(x => 1 + x/2)(1)

// to control oscillations is to prevent the estimation from varying too much.
// This is done by averaging successive values of the original sequence
//def sqrt(x: Double) = fixedPoint(y => x / y)(1)
//def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)



def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2

def sqrt(x: Double) =
  fixedPoint(averageDamp(y => x / y))(1)

sqrt(2)
















