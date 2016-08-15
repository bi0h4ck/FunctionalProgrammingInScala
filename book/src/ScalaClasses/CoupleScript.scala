/**
  * Created by diempham on 8/15/16.
  */
val coupleIntString = new Couple(10, "Scala") //Couple[Int, String]
val coupleIntString2: Couple[Int, String] = Couple(10, "Scala") //Couple[Int, String]
val coupleStringString = Couple("Scala", "Java") //Couple[String, String]
val coupleDoubleInt = Couple(12.12, 9) //Couple[Double, Int]
val coupleStringCoupleIntDouble = Couple("Hello", Couple(2, 34.21)) //Couple[String, Couple[Int, Double]]

println(coupleStringCoupleIntDouble.second.second) //34.21

val employeeCouple = Couple(new Employee("John", "Pal"), new Employee("Mary", "Puig"))
println(employeeCouple) //Couple(Employee(John, Pal, Programmer),Employee(Mary, Puig, Programmer))
println(employeeCouple.swap) //Couple(Employee(Mary, Puig, Programmer),Employee(John, Pal, Programmer))