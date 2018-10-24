package Playground.FunctionsAndClosures

import java.io.File

import scala.io.Source

/**
  * Created by e30462 on 10/23/18.
  */
object LocalFunction extends App {
  def processFile(filename: String, width: Int) = {
    def processLine(filename: String, width: Int, line: String) = {
      if (line.length > width) {
        println(filename + ": " + line.trim)
      }
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(filename, width, line)
    }
  }

  processFile(new File(".").getCanonicalPath() + "/src/Playground/FunctionsAndClosures/LongLines.scala", 45)
}

