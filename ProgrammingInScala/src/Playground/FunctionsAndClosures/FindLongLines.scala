import Playground.FunctionsAndClosures.LongLines

/**
  * Created by e30462 on 10/23/18.
  */

object FindLongLines extends App {
  val width = args(0).toInt
  for (arg <- args.drop(1))
    LongLines.processFile(arg, width)
}
