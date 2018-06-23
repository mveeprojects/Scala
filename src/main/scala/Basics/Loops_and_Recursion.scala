package Basics

object Loops_and_Recursion {

  def main(args: Array[String]): Unit = {
    var i = 0
    whileLoop(i)
    doWhileLoop(i)
  }

  def whileLoop(n: Int): Unit = {
    println("\nwhile loop")
    var i = n
    while (i < 10) {
      println(i)
      i += 1
    }
  }

  def doWhileLoop(n: Int): Unit = {
    println("\ndo-while loop")
    var i = n
    do {
      println(i)
      i -= 1
    } while (i > 0)
  }
}
