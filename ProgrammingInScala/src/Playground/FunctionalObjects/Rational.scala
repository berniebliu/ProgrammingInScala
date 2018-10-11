package Playground.FunctionalObjects

/**
  * Created by Bernie on 10/10/18.
  */

/*
  1) What is Rational: Specification

    A rational number is a number that can be expressed as a ratio n / d, where n and d are integers, except d cannot be zero

    n is the numerator

    d is the denominator

    rational numbers can be added, subtracted, multiplied, and divided

  2) Constructing a Rational

    How will client programmers create a new Rational Object?

    Note: We want to make the Rational Object Immutable -> Client must provide all data needed by an instance

    Immutable Object trade-offs:

    Advantages:

      1) Immutable objects are often easier to reason about than mutable ones, because they don't have complex state spaces that change over time
      2) You can pass immutable objects around quite freely, whereas you may need to make copies of mutable objects before passing them to other code
      3) There is no way for two threads concurrently accessing an immutable to corrupt its state once its been properly constructed
      4) Immutable objects make safe hash table keys

    Disadvantages:

      1) Large Object Graphs must be copied instead of an inplace update
      2) Libraries can provide mutable alternatives to immutable clases
 */

class Rational(n: Int, d: Int) {

  /*
    Checking Preconditions
   */

  require(d != 0)

  /*
    Creating Private Fields and Methods
   */

  private val g = gcd(n.abs, d.abs)

  /*
    Defining Fields
   */

  val numer = n / g
  val denom = d / g

  /*
    Auxiliary Constructor
   */

  def this(n: Int) = this(n, 1)

  /*
    Reimplementing the toString method to help debug
   */
  override def toString = numer + "/" + denom

  /*
   Method Overloading
  */

  def + (that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def + (i: Int): Rational = new Rational(numer + i * denom, denom)

  def - (that: Rational) = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  def - (i: Int): Rational = new Rational(numer + i * denom, denom)

  def * (that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)
  def * (i: Int): Rational = new Rational(numer * i, denom)

  def / (that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)
  def / (i: Int): Rational = new Rational(numer, denom * i)

  /*
    Creating Private Fields and Methods
  */

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  /*
    Implicit Conversions
   */

  implicit def intToRational(x: Int) = new Rational(x)
}
