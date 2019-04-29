package mapsAndFlatmaps

// https://alvinalexander.com/scala/create-iterating-scala-string-maps

object MapBasics {

  private val numList = List(1, 2, 3, 4, 5, 6)
  private val myMap = Map("name" -> "Mark", "age" -> "32")

  def main(args: Array[String]): Unit = {
    multiplyAllBy2Simple()
    multiplyAllByTwoShorthand()
    mapUsingFunction()
    mapMapKeyValues()
    mapMapKV_ToList()
  }

  def multiplyAllBy2Simple(): Unit = {
    println("*** Maps - Multiply By 2 - Basic ***")
    println("\nList:")
    val numTimesTwoList = numList.map(elementVal => elementVal * 2)
    numTimesTwoList.foreach(println)
  }

  def multiplyAllByTwoShorthand(): Unit = {
    println("\n*** Maps - Multiply By 2 - Shorthand ***")
    val numTimesTwoList = numList.map(_ * 2)
    numTimesTwoList.foreach(println)
  }

  def mapUsingFunction(): Unit = {
    println("\n*** Maps - Map Using Function ***")
    val numGreaterThanTwoList = numList.map(elementVal => myFunction(elementVal))
    numGreaterThanTwoList.foreach(println)
  }

  def myFunction(x: Int): Option[Int] = if (x > 2) Some(x) else None

  def mapMapKeyValues(): Unit = {
    println("\n*** Maps - Mutating values in a Map/Tuple using the map function ***")
    val abc: Map[String, String] = myMap.map { aMap =>
      if (aMap._1 == "age")
        (aMap._1, (aMap._2.toInt * 2).toString)
      else
        aMap
    }
    abc.foreach(m => println(m._1 + " " + m._2))
  }

  def mapMapKV_ToList(): Unit = {
    println("\n*** Maps - Transforming a map to a list ***")
    val aList: List[String] = myMap.map(aMap => aMap._1 + " " + aMap._2).toList
    aList.foreach(println)
  }
}