//import scala.reflect.runtime.Settings.IntSetting

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val n = x
  val d = y

  def + (that: Rational) =
    new Rational(n * that.d + that.n * d,
      d * that.d)

  def < (that: Rational) = n * that.d < that.n * d

  def max(that: Rational) = if (this < that) that else this

  def unary_- : Rational = new Rational(-n, d)

  def - (that: Rational) = this + -that

  override def toString  = {
    val g = gcd(n, d)
    n / g + "/" + d / g
  }
}


val x = new Rational(1, 2) //x: Rational = 1/2
  x.n //res0: Int = 1
  x.d //res1: Int = 2

val y = new Rational(2, 3) //y: Rational = 2/3
  x + y //res2: Rational = 7/6























