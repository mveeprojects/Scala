package examples

object FlattenMain extends App {

  val listOfOptions: List[Option[String]] = List(Some("goldfish"), None, Some("bacon"), None, None, Some("potato"))
  println(s"listOfLists: $listOfOptions")

  val flattenedList: List[String] = listOfOptions.flatten
  println(s"flattenedList: $flattenedList")
}