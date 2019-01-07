package mapsAndFlatmaps

object MapsAndListOfOptions {

  private val stringList = List("1", "2", "Blah", "3")

  def main(args: Array[String]): Unit = {
    optionsListFlatMap()
    optionsListMapThenFlatten()
  }

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in))
    } catch {
      case e: Exception => None
    }
  }

  def optionsListFlatMap(): Unit = {
    println("\n****** Flatmaps can be used to directly grab the value of Options rather than the Option itself: ******")
    val result = stringList.flatMap(toInt)
    println(result)
  }

  def optionsListMapThenFlatten(): Unit = {
    println("\n****** Simulating the same thing in steps with map and flatten: ******")
    println("1) map gets the list of Options")
    val map = stringList.map(toInt)
    println(map)
    println("\n2) flatten then gets the value from each Option")
    val flatten = map.flatten
    println(flatten)
  }
}