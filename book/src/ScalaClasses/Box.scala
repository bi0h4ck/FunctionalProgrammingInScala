/**
  * Created by diempham on 8/14/16.
  */
case class Box[T](t:T) {
  def coupleWith[U](u: U): Box[Couple[T, U]] = Box(Couple(t, u))
}

