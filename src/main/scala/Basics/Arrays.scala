package Basics

import scala.collection.mutable.ArrayBuffer

object Arrays {

  def main(args: Array[String]): Unit = {
    arrayExample()
    arrayBufferExample()
  }

  def arrayExample(): Unit = {
    val faveNums = new Array[Int](12)
    val friends = Array("Bob", "Sally")
    println(friends(0))
    print("\n")
  }

  def arrayBufferExample(): Unit = {
    val cars = ArrayBuffer[String]()
    cars += "Ford"
    cars ++= Array("Ferrari", "Audi")
    for (i <- cars.indices){
      println(cars(i))
    }
  }
}
