package options

object OptionsExample {

  def main(args: Array[String]) {
    checkStringAsNumber("1234f")
    checkMap()
    getOrElseExample()
  }

  def checkStringAsNumber(in: String): Unit = {
    println("Number checking example:")
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
    println("\nMap checking example:")
    val capitals = Map("Britain" -> "London", "Japan" -> "Tokyo")
    println("show(capitals.get( \"Japan\")) : " + findInMapIfExists(capitals.get("Japan")))
    println("show(capitals.get( \"France\")) : " + findInMapIfExists(capitals.get("France")))
  }

  def findInMapIfExists(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }

  def getOrElseExample(): Unit = {
    println("\ngetOrElse example:")
    val i = toInt("5").get
    val j = toInt("j")

    val a: Option[Int] = Some(i)
    val b: Option[Int] = Some(j.getOrElse(12))
    val c: Option[Int] = None

    println("a.getOrElse(0): " + a.getOrElse(0))
    println("b.getOrElse(10): " + b.get)
    println("c.getOrElse(10): " + c.getOrElse(10))
  }

  // either
}