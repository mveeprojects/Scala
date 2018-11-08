package mapsAndFlatmaps

object MapVsFlatmap {

  private val nameList = List("Mark", "Bob", "Sally")

  def main(args: Array[String]): Unit = {
    mapBasicConcept()
    flatMapBasicConcept()
    mapThenFlattenProof()
  }

  def mapBasicConcept(): Unit = {
    println("\nMaps are simple conversions on the immediately available objects (Strings in this case)")
    val result: List[String] = nameList.map(_.toUpperCase)
    println(result)
  }

  def flatMapBasicConcept(): Unit = {
    println("\nFlatmaps are maps that are then flattened to a lower level (array of char in this case)")
    val result: List[Char] = nameList.flatMap(_.toLowerCase)
    println(result)
  }

  def mapThenFlattenProof(): Unit = {
    println("\nTo prove this theory, here's an example of running map and then flatten seperately")
    val result = nameList.map(_.toLowerCase).flatten
    println(result)
  }
}