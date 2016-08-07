val t1 = new NonEmpty(3, new Empty, new Empty) //t1: NonEmpty = {.3.}
val t2 = t1 incl 4 //t2: IntSet = {.3{.4.}}
val t3 = t2 incl 1 //t3: IntSet = {{.1.}3{.4.}}
val t4 = new Empty //t4: Empty = .
val t5 = t4 incl 7 //t5: IntSet = {.7.}
val t6 = t3 union t5 //t6: IntSet = {{.1{{.3.}4.}}7.}
val t7 = t5 union t3 //t7: IntSet = {{.1.}3{.4{.7.}}}



abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString = "{" + left + elem + right + "}"

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
}
























