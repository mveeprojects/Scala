package collections

object mapObjectValuesInCollection {

  def main(args: Array[String]): Unit = {
    mapValues()
  }

  def mapValues(): Unit = {
    for (req <- requests) {
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
