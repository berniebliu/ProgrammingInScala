package Playground.BuiltInControlStructures

/**
  * Created by Bernie on 10/16/18.
  */

object ControlStructures extends App {

  /*
    IF EXPRESSIONS
   */
  var filename = "default.txt"
  if (!args.isEmpty)
    filename = args(0)

  // val vs var, val tells readers of the code that the variable will never change

  val fname =
    if (!args.isEmpty) args(0)
    else "default.txt"

  // using val instead of a var is that it better supports equational reasoning.
  // the introduced variable is equal to the expression that computes it

  /*
    Look for opportunities to use vals. They can make your code both easier to read and easier to refactor
   */

  /*
    WHILE LOOPS

    Challenge while loops in your code in the same way you challenge cars. In fact, while loops and vars often go hand in hand. Because while
    loops don't result in a value, to make any kind of difference to your program, a while loop will usually either need to update vars or perform I/O
   */

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  println(gcdLoop(2, 10))

  /*
    FOR EXPRESSIONS
   */

  // Iteration through collections

  val filesHere = (new java.io.File(".")).listFiles

  for (file <- filesHere)
    println(file)

  for (i <- 1 to 4)
    println("Iteration " + i)

  // Filtering

  for (file <- filesHere if file.getName.endsWith(("ProgrammingInScala.iml")))
    println(file)

  for (
    file <- filesHere
    if (file.isFile)
    if file.getName.endsWith("ProgrammingInScala.iml")
  ) println(file)

  // Nested Iteration

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toArray

  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

  println(grep("content"))

  val firstArg = if (args.length > 0) args(0) else ""

  val friend =
    firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh")
  }

  println(friend)

  def exampleMatch(input: String) = {
    if (input.length > 0)
      input match {
        case "salt" => println("pepper")
        case "chips" => println("salsa")
        case "eggs" => println("bacon")
        case _ => println("huh")
      }
    else ""
  }

  println(exampleMatch("salt"))

  /*
    Living Without Break and Continue
    Scala leaves out these commands because they do not mesh well with function literals
   */

  val searchList: List[String] = List("junk", "junk", ".scala")

  def searchFromRecurse(i: Int, search: List[String]): Int =
    if (i >= search.length) -1
    else if (search(i).startsWith("-")) searchFromRecurse(i + 1, search)
    else if (search(i).endsWith(".scala")) i
    else searchFromRecurse(i + 1, search)

  println(searchFromRecurse(0, searchList))

  // iterative example
  val i = 0
  val search = List("junk", "junk", ".scala")
  val retIndex = for {
    index <- i to search.length -1
    if search(index).endsWith(".scala")
  } yield index

  for (i <- retIndex)
    println(i)


def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }


}


