package mapsAndFlatmaps

object MapsAndFunctions {

  private val intList = List(1, 2, 3, 4, 5, 6)
  private val doubleList = List(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)

  def main(args: Array[String]): Unit = {
    mapWithFunction()
    flatMapWithFunction()
    flatMapListOfInts()
  }

  def myFunction(in: Int) = List(in - 1, in, in + 1)

  def mapWithFunction(): Unit = {
    println("\n****** Using map to get the top level List (list of lists): ******")
    val mappedList: List[List[Int]] = intList.map(in => myFunction(in))
    println(mappedList)
  }

  def flatMapWithFunction(): Unit = {
    println("\n****** Using flatmap to get the lowest level List (all integers expanded out of each nested list): ******")
    val flatMappedList: List[Int] = intList.flatMap(in => myFunction(in))
    println(flatMappedList)
  }

  def flatMapListOfInts(): Unit = {
    println("\n****** Using flatmap to get the lowest level List (all chars expanded out of each Double.toString()): ******")
    val flatMapIntList: List[Char] = doubleList.flatMap(_.toString)
    println(flatMapIntList)
  }
}