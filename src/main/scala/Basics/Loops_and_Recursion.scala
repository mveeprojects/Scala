package Basics

object Loops_and_Recursion {

  def main(args: Array[String]): Unit = {
    val i = 0
    whileLoop(i)
    doWhileLoop(i)
    forLoop()
    iterateList(List(1, 7, 4, 2, 12))
    forLoopWithConditional()
    nestedForLoop()
  }

  def whileLoop(n: Int): Unit = {
    println("\nWhile loop")
    var i = n
    while (i < 10) {
      println(i)
      i += 1
    }
  }

  def doWhileLoop(n: Int): Unit = {
    println("\nDo-While loop")
    var i = n
    do {
      println(i)
      i -= 1
    } while (i > 0)
  }

  def forLoop(): Unit = {
    println("\nFor loop")
    for (i <- 1 to 10) {
      println(i)
    }

    println("\nFor loop - over a string")
    val randLetters = "ABCDEFGHIJKLM"
    for (i <- 0 until randLetters.indexOf("J"))
      println(randLetters(i))
  }

  def iterateList(aList: List[Int]): Unit = {
    println("\nIterating over a list")
    for (i <- aList)
      println(i)
  }

  def forLoopWithConditional(): Unit = {
    println("\nLoops with conditionals")
    var evenList = for {i <- 1 to 20
                        if (i % 2) == 0
    } yield i

    iterateList(evenList.toList)
  }

  def nestedForLoop(): Unit = {
    println("\nNested for loops")
    for (i <- 1 to 6; j <- 2 to 7)
      println("i: " + i + " j: " + j)

  }
}