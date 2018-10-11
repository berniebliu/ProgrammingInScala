package Playground.BasicTypesAndOperations

/**
  * Created by Bernie on 10/10/18.
  */
object BasicTypes extends App {
  /*
    Integral Types: Byte (-2^7 to 2^7 - 1), Short (-2^15 to 2^15 - 1), Int (-2^31 to 2^31 - 1), Long (-2^63 to 2^63 - 1), and Char (0 to 2^16 - 1)
    Numeric Types: Float (32-bit IEEE 754 single-precision float) and Double (64-bit IEEE 754 double-precision float)
   */

  /*
    Literal: A way to write a constant value directly in code
   */

  val hex = 0x5
  println(hex)
  val hex2 = 0x00FF
  println(hex2)

  /*
    Scala shell always prints integer values in base 10, unless the value is assigned to a variable of type Short or Byte
   */

  val little: Short = 367
  println(little)

  /*
    Special Characters:
      \n, \b, \t, \f, \r, \", \', \\

    For new lines use the pipe character at the front of each line and then call stripMargin on the whole string
   */

  println(
    """Welcome to Ultamix 3000.
      |Type "HELP" for help.
    """.stripMargin)

  /*
    Symbol Literal: Symbol literals are mapped to instances of the predefined class scala.Symbol, they are typically used in situations where you would use just an identifier in a dynamically typed language
    Example: 'ident , begins with '
   */

  def updateRecordByName(r: Symbol, value: Any) = {
    // code goes here
    println(r.name)
    println(value)
  }

  updateRecordByName('favoriteAlbum, "Ok Computer")

  /*
    String Interpolation: The s interpolator will evaluate each embedded expression, invoke toString on each result, and replace the embedded expressions
    You can place any expression after a dollar sign ($) in a processed string literal

    Scala also provides two other string interpolators by default: raw and f

    If you provide no formatting instructions for embedded expression, the f string interpolator will default to %s
   */

  val name = "reader"
  println(s"Hello $name!")

  println(s"The answer is ${6 * 7}.")

  println(raw"No\\\\escape!")

  println(f"${math.Pi}%.5f")

}
