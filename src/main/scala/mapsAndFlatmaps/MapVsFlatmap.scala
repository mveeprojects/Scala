package mapsAndFlatmaps

object MapVsFlatmap {

  private val nameList = List("Mark", "Bob", "Sally")

  def main(args: Array[String]): Unit = {
    mapBasicConcept()
    flatMapBasicConcept()
    mapThenFlattenProof()
  }

  def mapBasicConcept(): Unit = {
    println("\n****** Maps are simple conversions on the immediately available objects (Strings in this case)******")
    val result: List[String] = nameList.map(_.toUpperCase)
    println(result)
  }

  def flatMapBasicConcept(): Unit = {
    println("\n****** Flatmaps are maps that are then flattened to a lower level (array of char in this case) ******")
    val result: List[Char] = nameList.flatMap(_.toLowerCase)
    println(result)
  }

  def mapThenFlattenProof(): Unit = {
    println("\n****** To prove this theory, here's an example of running map and then flatten seperately ******")
    val mapped = nameList.map(_.toLowerCase)
    val flattened = mapped.flatten
    println(flattened)
  }
}