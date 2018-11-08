package mapsAndFlatmaps

object MapBasics {

  val numList = List(1, 2, 3, 4, 5, 6)
  val numArray = Array(1, 2, 3, 4, 5, 6)
  val numSet = Set(1, 2, 3, 4, 5, 6)
  val myMap = Map("key1" -> 1, "key2" -> 2)

  def main(args: Array[String]): Unit = {
    multiplyAllBy2Simple()
    multiplyAllByTwoShorthand()
    mapUsingFunction()
    mapMapKeyValues()
    mapMapKV_ToList()
  }

  def multiplyAllBy2Simple(): Unit = {
    println("*** Maps - Multiply By 2 - Simple ***")
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

  def multiplyAllByTwoShorthand(): Unit = {
    println("\n*** Maps - Multiply By 2 - Shorthand ***")
    val numTimesTwoList = numList.map(_ * 2)
    for (element <- numTimesTwoList) println(element)
    println()
  }

  def mapUsingFunction(): Unit = {
    println("\n*** Maps - Map Using Function ***")
    val numGreaterThanTwoList = numList.map(elementVal => myFunction(elementVal))
    for (element <- numGreaterThanTwoList) println(element)
    println()
  }

  def myFunction(x: Int): Option[Int] = if (x > 2) Some(x) else None

  def mapMapKeyValues(): Unit = {
    println("\n*** Maps - Map Key Values ***")
    myMap.map { keyValue: (String, Int) =>
      keyValue match {
        case (key, value) => (key, value * 2)
      }
    }
    for ((k, v) <- myMap) {
      println(k + ", " + v)
    }
  }

  def mapMapKV_ToList(): Unit = {
    println("\n*** Maps - Example Five ***")
    val aList = myMap.map {
      case (key, value) => value * 2
    }.toList
    for (value <- aList) {
      println(value)
    }
  }
}