package Playground.Examples

/**
  * Created by Bernie on 10/23/18.
  */
object MultiplicationTable extends App {
  def makeRowSequence(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int) = makeRowSequence(row).toString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)

    tableSeq.mkString("\n")
  }

  println(multiTable())
}
