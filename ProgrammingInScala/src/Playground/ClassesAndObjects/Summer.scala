package Playground.ClassesAndObjects

/**
  * Created by Bernie on 10/8/18.
  */

import CheckSumAccumulator.calculate

object Summer extends App {
  for (season <- List("fall", "winter", "spring")) {
    println(season + ": " + calculate(season))
  }
}
