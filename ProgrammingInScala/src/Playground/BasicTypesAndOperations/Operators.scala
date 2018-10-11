package Playground.BasicTypesAndOperations

/**
  * Created by Bernie on 10/10/18.
  */
object Operators extends App {
  /*
    Operators are methods
   */

  val sum = 1 + 2
  println(sum)

  val sumMore = 1.+(2)
  println(sumMore)

  /*
    Int contains several overloaded + methods that take different parameter types

    If you add a Long to an Int, this alternate + method will be invoked
   */

  val longSum = 1 + 2L

  val s = "Hello World"

  /*
    String offers an overloaded indexOf method that takes two parameters

    Any method can be an operator, in Scala operators are not special language syntax; any method can be an operator

    When you write s.indexOf('o'), indexOf is not an operator
    When you write s indexOf 'o', indexOf is an operator because you're using it in operator notation
 */

  println(s indexOf 'o')

  println(s indexOf('o', 5))

  println(s toLowerCase)

  def salt() = { println("salt"); false }
  def pepper() = { println("pepper"); true }

  println(pepper() && salt())


  /*
    Object equality:
      ==, !=
    Object equality applies to all objects, not just basic types.

    You can compare two objects that have different types

    You can compare against nul or against things that might be null

    Scala provides a facility for comparing reference equality, as well, under the name eq

   */

  println(List(1, 2, 3) == List(1, 2, 3))

  println(1 == 1.0)

  println("he" + "llo" == "hello")

  /*
    Operator precedence and associativity

    Scala decides precedence based on the first character of the methods used in operator notation

    1) all other special characters
    2) * / %
    3) + -
    4) :
    5) = !
    6) < >
    7) &
    8) ^
    9) |
    10) all letters
    11) all assignment operators

    if a method ends in :, they are grouped right to left
   */

  println(0 max 5)

  println(4 * -2.7 abs)

  println(4 to 6)

  println("robert" drop 2)
}
