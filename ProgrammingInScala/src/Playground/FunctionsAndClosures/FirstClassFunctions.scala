package Playground.FunctionsAndClosures

/**
  * Created by e30462 on 10/23/18.
  */
object FirstClassFunctions extends App {
  var increase = (x: Int) => x + 1
  println(increase(10))

  println()

  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  someNumbers.foreach((x: Int) => println(x))
  // Passing in a function into the filter method

  println()

  val filteredNumbers = someNumbers.filter((x: Int) => x > 0)
  filteredNumbers.foreach((x: Int) => println(x))

  // scala compiler allows you to leave out redundant information and write function literals more briefly
  // below example, the Scala compiler knows that x must be an integer
  someNumbers.filter((x) => x > 0)

  someNumbers.filter(x => x > 0)

  // placeholder syntax: allows you to make a function literal even more concise
  // the underscore is a placeholder for one or more parameters
  // you can think of the underscore as a "blank" in the expression that needs to be "filled in"
  someNumbers.filter(_ > 0)

  println()

  val f = (_: Int) + (_: Int)
  println(f(5, 10))

  println()

  // underscore can also be a placeholder for a singe parameter or for an entire parameter list

  someNumbers.foreach(println _)
}
