package Playground.ClassesAndObjects

import scala.collection.mutable

/**
  * Created by Bernie on 10/8/18.
  */

object CheckSumAccumulator {

  // a class is a blueprint for an object
  class CheckSumAccumulator {
    private var sum = 0

    // method parameters are vals! cannot reassign a parameter
    // a method executed only for its side effects is known as a procedure
    def add(b: Byte): Unit = {
      sum += b
    }

    def checkSum(): Int = {
      return ~(sum & 0xFF) + 1
    }
  }

  // Singleton Example

  private val cache = mutable.Map.empty[String, Int]

  /*
    Cycle through each character in the passed string, convert the character to a Byte, and pass that to the add method of the
    CheckSumAccumulator instance to which acc refers which gets the checksum for the passed String, and stores it into a val named cs
    the passed string key is mapped to the integer checksum value, and this key-value pair is added to the cache map
    the last expression of the method, cs, ensures that the checksum is the result of the method
   */
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new CheckSumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checkSum()
      cache += (s -> cs)
      cs
    }

  // A singleton object is a first-class object, an object with a name tag
  // Singleton objects cannot take parameters, whereas classes can
  // A singleotn object is initialized the first time some code accesses it, it is a standalone object (utility methods or entry point)
}


