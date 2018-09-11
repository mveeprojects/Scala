package mainConcepts.higherOrderFunctions

// Higher order function: function that takes other functions as parameters

object Higher_Order_Functions {

  val testList = List(1, 3, 5, 7, 11)

  def main(args: Array[String]): Unit = {
    mapping()
    filtering()
    printf("3 * 100 = %.1f\n\n", passingFunctionIntoFunction(times3, 100))

    println(anotherHo(add, 3, 4))
    println(anotherHo(subtract, 3, 4))
    println(anotherHo(multiply, 3, 4))
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

  private def add(a: Int, b: Int): Int = {
    println("Add function being used...")
    a + b
  }

  private def subtract(a: Int, b: Int): Int = {
    println("Subtract function being used...")
    a - b
  }

  private def multiply(a: Int, b: Int): Int = {
    println("Multiply function being used...")
    a * b
  }

  private def anotherHo(anotherFunction: (Int, Int) => Int, a: Int, b: Int): Int = {
    println("Function being called with another function as the first parameter...")
    anotherFunction(a, b)
  }
}