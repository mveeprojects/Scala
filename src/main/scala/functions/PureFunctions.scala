package functions

// https://alvinalexander.com/scala/fp-book/definition-of-pure-function
// A Pure Function cannot modify state of anything outside of the function itself (e.g. IO, modifying mutable variables)
// A Pure Function can only work with the input it receives, the output of the function should always be the same for a given input
// A Pure Function does not modify its input parameters

object PureFunctions extends App {

  private val numberList = List(1, 2, 3, 4, 5, 6)
  private val numberListAfterPureFunction = numberList.map(timesTwo)
  printListValues(numberListAfterPureFunction)

  // This is pure
  def timesTwo(input: Int): Int = {
    input * 2
  }

  // This is not pure, because;
  // a) it modifies the input params (+ 1 to each)
  // b) it returns nothing and performs an IO operation (println)
  def printListValues(inputList: List[Int]): Unit = {
    inputList
      .map(intFromInputList => intFromInputList + 1)
      .foreach(println)
  }
}