package Playground

import scala.io.Source

/**
  * Created by Bernie on 10/8/18.
  */
object HelloWorld extends App {
  val message: String = "Hello World"
  println(message)

  def max(x: Int, y: Int): Int = {
    if (x > y) x else y
  }

  println(max(2, 4))

  def greet() = { println("Hello. Nice to meet you!")}

  greet()

  // Arrays are mutable
  val numNames = Array("zero", "one", "two")
  for (i <- 0 to 2)
    println(numNames(i))

  // Lists are immutable
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour
  println(oneTwo + " and " + threeFour + " were not mutated.")
  println("Thus, " + oneTwoThreeFour + " is a new list.")

  val oneTwoThree = 1 :: 2 :: 3 :: Nil
  println(oneTwoThree)

  // Tuples are immutable
  val pair = (99, "Luftballons")
  println(pair._1)
  println(pair._2)

  // Sets and maps can be mutable or immutable (Default is immutable)
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))
  println(jetSet)

  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumeral(4))

  def printArgs(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg)
  }

  val arrayToPrint = Array("one", "two", "three")
  printArgs(arrayToPrint)

  def formatArgs(args: Array[String]) = args.mkString(" ")
  val res = formatArgs(arrayToPrint)
  assert(res == "one two three")

  def printFile(args: Array[String]) = {
    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines())
        println(line.length + " " + line)
    } else {
      Console.err.println("Please enter filename")
    }
  }

  def widthOfLength(s: String) = s.length.toString.length

  def printFileWithPipe(args: Array[String]) = {
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines.toList

      val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b
      )

      val maxWidth = widthOfLength(longestLine)

      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }

      println(lines)

    } else {
      Console.err.println("Please enter filename")
    }
  }

  printFileWithPipe(Array("/Users/Bernie/Desktop/ScalaPlayground/ProgrammingInScala/src/Playground/file"))
}
