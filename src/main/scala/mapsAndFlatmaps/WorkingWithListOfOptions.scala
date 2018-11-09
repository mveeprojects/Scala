package mapsAndFlatmaps

object WorkingWithListOfOptions {

  private val stringList = List("1", "2", "Blah", "3")

  def main(args: Array[String]): Unit = {
    optionsListFlatMap()
    optionsListMapThenFlatten()
    myThing()
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

  def myThing(): Unit ={
    for (req <- requests){
      println(returnCorrectProp(req.proposition))
    }
  }

  val propositionMap = Map(
    "cProp" -> "c_Prop"
  )

  val requests = List(
    request("GB", "a_Prop", "eng"),
    request("GB", "b_Prop", "eng"),
    request("GB", "cProp", "eng")
  )

  def returnCorrectProp(key: String): String = {
    if (propositionMap.contains(key)) {
      propositionMap(key)
    } else {
      key
    }
  }
}

case class request(territory: String, proposition: String, language: String)