package options

object OptionsExample {

  def main(args: Array[String]) {
    checkStringAsNumber("1234f")
    checkMap()
  }

  def checkStringAsNumber(in: String): Unit = {
    println("\n\nNumber checking example:")
    toInt(in) match {
      case Some(i) => println(i)
      case None => println(in + " isn't a number")
    }
  }

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }

  def checkMap(): Unit = {
    println("\n\nMap checking example:")
    val capitals = Map("Britain" -> "London", "Japan" -> "Tokyo")
    println("show(capitals.get( \"Japan\")) : " + findInMapIfExists(capitals.get("Japan")))
    println("show(capitals.get( \"France\")) : " + findInMapIfExists(capitals.get("France")))
  }

  def findInMapIfExists(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }
}