package collections

import com.typesafe.scalalogging.LazyLogging

// foldLeft uses two parameters
// 1st = seed value
// 2nd = function to perform for each pair in order from left to right - hence "foldLEFT"

object FoldAndMapReduce extends App with LazyLogging {

  recursiveCallExample()
  inlineFunctionExample()
  integerMapReduceSumExample()
  integerMapReduceProductExample()

  private val intList    = List(1, 2, 3, 4, 5, 6)
  private val doubleList = List(1.0, 2.5, 3.5)
  private val strings    = List("item1", "item2", "item3", "item4")

  def recursiveCallExample(): Unit = {
    //    val sumOfDoubles = doubleList.foldLeft(0.0)(_ + _)
    val sumOfDoubles = doubleList.foldLeft(0.0)(sumTwoDoubles)
    logger.info(s"Result of recursive call on double list -> $sumOfDoubles")
  }

  def sumTwoDoubles(a: Double, b: Double): Double =
    a + b

  def inlineFunctionExample(): Unit = {
    val foldLeftInlineFunctionResult: String = strings.foldLeft("") { (acc, item) =>
      acc + item + "/"
    }
    val outResult: String = foldLeftInlineFunctionResult.patch(foldLeftInlineFunctionResult.lastIndexOf('/'), "", 1)
    logger.info(s"Result of inline function on double list -> $outResult")
  }

  def integerMapReduceSumExample(): Unit = {
    val resultOfMapReduce: Int = intList.sum
    logger.info(s"Result of integer list(...).sum -> $resultOfMapReduce")
  }

  def integerMapReduceProductExample(): Unit = {
    val resultOfMapReduce: Int = intList.product
    logger.info(s"Result of integer list(...).product -> $resultOfMapReduce")
  }
}
