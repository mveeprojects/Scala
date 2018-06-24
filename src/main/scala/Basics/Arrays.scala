package Basics

import scala.collection.mutable.ArrayBuffer

object Arrays {

  val people = new Array[String](6)
  val numbers = Array(4, 7, 2, 12)

  def main(args: Array[String]): Unit = {
    populateArray()
    arrayExample()
    arrayBufferExample()
    transformDataInArray()
    functionalArrayCreation()
    multiDimensionalArray()
    sumMinMaxArrayValues(numbers)
    sortArray(numbers)
  }

  private def populateArray(): Unit = {
    people(0) = "Mark"
    people(1) = "Sally"
    people(2) = "Dave"
    people(3) = "Gertrude"
    people(4) = "Betsy"
    people(5) = "Peter"
  }

  private def arrayExample(): Unit = {
    val friends = Array(people(2), people(4))
    printArray(friends)
    print("\n")
  }

  private def arrayBufferExample(): Unit = {
    val cars = ArrayBuffer[String]()
    cars += "Ford"
    cars ++= Array("Ferrari", "Audi")
    printArray(cars.toArray)
    print("\n")
  }

  private def transformDataInArray(): Unit = {
    val newPeopleList = for (person <- people) yield person + " is a person"
    printArrayForEach(newPeopleList)
    print("\n")
  }

  private def functionalArrayCreation(): Unit = {
    val newNumberList = for (number <- numbers if number % 4 == 0) yield number.toString
    printArrayForEach(newNumberList)
    print("\n")
  }

  private def multiDimensionalArray(): Unit = {
    var multiDimArray = Array.ofDim[Int](10, 10)
    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        multiDimArray(i)(j) = i * j
      }
    }
    printMultiDimArray(multiDimArray)
    print("\n")
  }

  private def sumMinMaxArrayValues(arr: Array[Int]): Unit = {
    println("Sum, min and max of the  values in an array")
    println("Sum: " + arr.sum)
    println("Min: " + arr.min)
    println("Max: " + arr.max)
    print("\n")
  }

  private def sortArray(arr: Array[Int]): Unit = {
    println("Sorting an array in descending order")
    val sortArrDescending = arr.sortWith(_ > _)
    printArrayForEach(for (i <- sortArrDescending) yield i.toString)

    println("Sorting an array in ascending order")
    val sortArrAscending = arr.sortWith(_ < _)
    printArrayForEach(for (i <- sortArrAscending) yield i.toString)
  }

  private def printArray(arr: Array[String]): Unit = {
    println("Printing array with ordinary for loop")
    for (i <- arr.indices)
      println(i + " " + arr(i) + "\t")
  }

  private def printArrayForEach(arr: Array[String]): Unit = {
    println("Printing array with foreach loop")
    arr.foreach(println)
  }

  private def printMultiDimArray(arr: Array[Array[Int]]): Unit = {
    println("Printing multi-dimensional array")
    for (i <- 0 to 9) {
      for (j <- 0 to 9) {
        print(arr(i)(j) + "\t")
      }
      println()
    }
  }
}