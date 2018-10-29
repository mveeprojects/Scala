package mapsAndFlatmaps

object Maps {

  val numList = List(1, 2, 3, 4, 5, 6)

  def main(args: Array[String]): Unit = {
    mapExampleOne()
    mapExampleTwo()
  }

  def mapExampleOne(): Unit = {
    val numTimesTwoList = numList.map(elementVal => elementVal*2)
    for (element <- numTimesTwoList) println(element)
    println()
  }

  def mapExampleTwo(): Unit = {
    val numGreaterThanTwoList = numList.map(elementVal => myFunction(elementVal))
    for (element <- numGreaterThanTwoList) println(element)
    println()
  }

  def myFunction(x: Int) = if(x > 2) Some(x) else None
}