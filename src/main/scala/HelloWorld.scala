object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello world " + sum(4,3))
  }

  def sum(a: Int, b: Int) : Int = {
    var sum:Int = 0
    sum = a + b
    sum
  }
}