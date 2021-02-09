package zip

// http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-zip-example/
// Zip is a way to merge two collections into a List of maps

object ZipExamples extends App {

  private val nameList                               = List("bob", "dave", "sally")
  private val ageList                                = List(21, 34, 25)
  private val zippedNamesToAges: List[(String, Int)] = nameList.zip(ageList)
  printCollection(zippedNamesToAges)
  println()

  // if you have collections of different lengths you can use zipAll to provide default values
  // watermelon and grapes in this example are both given the default price value
  private val fruitList    = List("apple", "orange", "pear", "watermelon", "grapes")
  private val priceList    = List(2, 3, 6)
  private val defaultPrice = 12
  printCollection(fruitList.zipAll(priceList, "", defaultPrice))

  def printCollection(coll: List[(String, Any)]): Unit =
    coll.foreach(println)
}
