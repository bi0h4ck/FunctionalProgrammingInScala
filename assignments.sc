object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def balance(chars: List[Char]): Boolean = {
    @scala.annotation.tailrec
    def check(chars: List[Char], num: Int = 0): Boolean = chars match {
      case _ if num < 0 => false
      case Nil => num == 0
      case head :: tail => check(tail, num)
      case head :: tail if head == '('=> check(tail, num + 1)
      case head :: tail if head == ')' => check(tail, num - 1)
    }
    check(chars)
  }

  val a = "())(".toList
  balance(a)





}





