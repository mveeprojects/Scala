package mainConcepts.higherOrderFunctions

object Higher_Order_Functions {

  val testList = List(1, 3, 5, 7, 11)

  def main(args: Array[String]): Unit = {
    mapping()
    filtering()
    printf("3 * 100 = %.1f\n\n", passingFunctionIntoFunction(times3, 100))
  }

  private def mapping(): Unit = {
    println("Mapping example")
    testList.map((i: Int) => i * 10).foreach(println)
    print("\n")
  }

  private def filtering(): Unit = {
    println("Filtering example")
    testList.filter(_ % 3 == 0).foreach(println)
    print("\n")
  }

  private def times3(num: Int) = num * 3

  private def passingFunctionIntoFunction(function: Int => Double, num: Int) = {
    println("Passing functions into functions")
    function(num)
  }
}