package mapsAndFlatmaps

object WorkingWithFunctions {

  private val intList = List(1, 2, 3, 4, 5, 6)

  def main(args: Array[String]): Unit = {
    mapWithFunction()
    flatMapWithFunction()
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
}