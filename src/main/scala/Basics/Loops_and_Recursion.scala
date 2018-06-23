package Basics

object Loops_and_Recursion {

  def main(args: Array[String]): Unit = {
    val i = 0
    whileLoop(i)
    doWhileLoop(i)
    forLoop()
    iterateString()
    iterateList(List(1, 7, 4, 2, 12))
    forLoopWithConditional()
    nestedForLoop()
  }

  def whileLoop(n: Int): Unit = {
    println("\nWhile loop")
    var i = n
    while (i < 10) {
      print(i + "\t")
      i += 1
    }
    print("\n")
  }

  def doWhileLoop(n: Int): Unit = {
    println("\nDo-While loop")
    var i = n
    do {
      print(i + "\t")
      i -= 1
    } while (i > 0)
    print("\n")
  }

  def forLoop(): Unit = {
    println("\nFor loop")
    for (i <- 1 to 10) {
      print(i + "\t")
    }
    print("\n")
  }

  def iterateString(): Unit = {
    println("\nIterating over a String")
    val randLetters = "ABCDEFGHIJKLM"
    for (i <- 0 until randLetters.indexOf("J"))
      print(randLetters(i) + "\t")
    print("\n")
  }

  def iterateList(aList: List[Int]): Unit = {
    println("\nIterating over a List")
    for (i <- aList)
      print(i + "\t")
    print("\n")
  }

  def forLoopWithConditional(): Unit = {
    println("\nLoop with conditionals")
    var evenList = for {i <- 1 to 20
                        if (i % 2) == 0
    } yield i

    for (i <- evenList)
      print(i + "\t")
    print("\n")
  }

  def nestedForLoop(): Unit = {
    println("\nNested for loops")
    for (i <- 1 to 6; j <- 2 to 7)
      println("i = " + i + " j = " + j)
    print("\n")
  }
}