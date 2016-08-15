val x = List(1, 2, 3, 4)
var result = List[Int]()
for (a <- x) {
  result = result :+ (a+2) //:+ append an item to a list
}
println(result)

val y = List(4, 5, 6, 7, 8)
val Y = for (b <- y) yield (b + 3)
println(Y)
println(y)


// Smart String
/* Smart Strings give us muti-line functionality
Smart Strings allow us to define our own margins
stripMargin uses pipes(|) by default
stripMargin accepts other characters
Smart Strings are great for regular expressions
*/
val lyrics =
  """I see trees or green,
    |Red roses too,
    |I see them bloom,
    |For me and you,
    |And I think to myself,
    |What a wonderful world
  """.stripMargin

println(lyrics)

val message = "We are meeting on June 13th of this year, and having lunch at 12:30PM"
val regex = """(\s|[0-9])?[0-9]:[0-5][0-9]\s*(AM|PM)""".r
println(regex.findAllIn(message).toList)



//Older Java Style
val str = String.format("This is a %s", "test")
println(str)

//Scala's style
val str2 = "This is a %s".format("test 2")
println(str2)

println("Counting down: %3$s, %2$s, %1$s".format("1", "2", "3"))

//import java.time._
//println("Today is %1$tB the %1$te in the year %1$tY".format(LocalDate.now()))


//String Interpolation
/*
performs variable replacement
requires an s before a String
braces may be required for evaluation
Use f interpolation to use C/Java-style formatting
Work great with Scala Smart String
 */
val c = 99
println(s"$c luftballons floating in the summer sky")
println(s"${c + 5} luftballons floating in the summer sky")

val ticketCost = 50
val bandName = "Psychedelic Furs"
println(f"The $bandName%s tickets are probably $$$ticketCost%1.2f")

val percentIncrease = 20
val musicGenre = "New Wave"
println(f"The $bandName%s tickets are probably $$$ticketCost%1.2f%nThat's a $percentIncrease%% bump because everyone likes $musicGenre")

///use scala smart string
println(f"""The $bandName%s tickets are probably $$$ticketCost%1.2f.
            |That's a $percentIncrease%% bump because everyone likes $musicGenre".stripMargin)














