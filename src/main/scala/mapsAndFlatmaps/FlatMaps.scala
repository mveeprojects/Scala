package mapsAndFlatmaps

object FlatMaps extends App {

  val stringList = List("apple", "banana", "orange")

  println("Flatmap - think map then flatten or \"mapFlat\"") // A P P L E ...
  stringList.flatMap(_.toUpperCase).foreach(println)

  println("Map") // APPLE BANANA ORANGE
  val mappedList = stringList.map(_.toUpperCase)
  mappedList.foreach(println)

  println("Flatten") // a p p l e ...
  val flattenedList = stringList.flatten
  flattenedList.foreach(println)

  println("\"Manual\" Flatmap") // A P P L E ...
  stringList.map(_.toUpperCase).flatten.foreach(println)
}


object FlatMapsOnOptions extends App {

  val maybeIntList = List("1", "seven", "6", "12")

  maybeIntList.flatMap(toInt).foreach(println)

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case _: Exception => None
    }
  }
}

object FlatMapListOfSeqs extends App {
  val intList = List(1, 2, 3)
  intList.map(x => Seq(x - 1, x, x + 1)).foreach(x => print(s"$x "))
  println
  intList.flatMap(x => Seq(x - 1, x, x + 1)).foreach(x => print(s"$x "))
}