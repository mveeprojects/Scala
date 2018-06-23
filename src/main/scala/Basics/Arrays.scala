package Basics

import scala.collection.mutable.ArrayBuffer

object Arrays {

  val people = new Array[String](6)

  def main(args: Array[String]): Unit = {
    populateArray()
    arrayExample()
    arrayBufferExample()
  }

  def populateArray(): Unit = {
    people(0) = "Mark"
    people(1) = "Sally"
    people(2) = "Dave"
    people(3) = "Gertrude"
    people(4) = "Betsy"
    people(5) = "Peter"
  }

  def arrayExample(): Unit = {
    val friends = Array(people(2), people(4))
    printArray(friends)
    print("\n")
  }

  def arrayBufferExample(): Unit = {
    val cars = ArrayBuffer[String]()
    cars += "Ford"
    cars ++= Array("Ferrari", "Audi")
    printArray(cars.toArray)
    print("\n")
  }

  def printArray(arr: Array[String]): Unit = {
    println("Printing array")
    for (i <- arr.indices)
      println(arr(i) + "\t")
  }
}
