package Maths

object Maths {

  def main(args: Array[String]): Unit = {
    val a = 3
    val b = 9
    println(a + "+" + b + "=" + sum(a, b))
  }

  def sum(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }
}
