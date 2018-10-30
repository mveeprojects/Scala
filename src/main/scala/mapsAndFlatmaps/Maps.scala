package mapsAndFlatmaps

object Maps {

  val numList = List(1, 2, 3, 4, 5, 6)
  val numArray = Array(1, 2, 3, 4, 5, 6)
  val numSet = Set(1, 2, 3, 4, 5, 6)
  val myMap = Map("key1" -> 1, "key2" -> 2)

  def main(args: Array[String]): Unit = {
    mapExampleOne()
    mapExampleTwo()
    mapExampleThree()
    mapExampleFour()
    mapExampleFive()
  }

  def mapExampleOne(): Unit = {
    println("*** Maps - Example One ***")
    println("\nList:")
    val numTimesTwoList = numList.map(elementVal => elementVal * 2)
    for (element <- numTimesTwoList) println(element)

    println("\nArray:")
    val numTimesTwoArray = numList.map(elementVal => elementVal * 2)
    for (element <- numTimesTwoArray) println(element)

    println("\nSet:")
    val numTimesTwoSet = numList.map(elementVal => elementVal * 2)
    for (element <- numTimesTwoSet) println(element)
  }

  def mapExampleTwo(): Unit = {
    println("\n*** Maps - Example Two ***")
    val numTimesTwoList = numList.map(_ * 2)
    for (element <- numTimesTwoList) println(element)
    println()
  }

  def mapExampleThree(): Unit = {
    println("\n*** Maps - Example Three ***")
    val numGreaterThanTwoList = numList.map(elementVal => myFunction(elementVal))
    for (element <- numGreaterThanTwoList) println(element)
    println()
  }

  def myFunction(x: Int): Option[Int] = if (x > 2) Some(x) else None

  def mapExampleFour(): Unit = {
    println("\n*** Maps - Example Four ***")
    myMap.map { keyValue: (String, Int) =>
      keyValue match {
        case (key, value) => (key, value * 2)
      }
    }
    for ((k, v) <- myMap) {
      println(k + ", " + v)
    }
  }

  def mapExampleFive(): Unit = {
    println("\n*** Maps - Example Five ***")
    val aList = myMap.map {
      case (key, value) => value * 2
    }.toList
    for (value <- aList) {
      println(value)
    }
  }
}