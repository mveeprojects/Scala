package mapsAndFlatmaps

object MapVsFlatmap {

  private val nameList = List("Mark", "Bob", "Sally")

  def main(args: Array[String]): Unit = {
    mapBasicConcept()
    flatMapBasicConcept()
  }

  def mapBasicConcept(): Unit = {
    println("Maps are simple conversions on the immediately available objects (Strings in this case)")
    println(nameList.map(_.toUpperCase))
  }

  def flatMapBasicConcept(): Unit = {
    println("Flatmaps are maps that are then flattened to a lower level (array of char in this case)")
    println(nameList.flatMap(_.toLowerCase))
  }
}