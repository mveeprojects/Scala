package mapOption

object main {

  val propositionMap = Map(
    "Go" -> "SKYGO"
  )

  val requests = List(
    request("GB", "NOWTV", "eng"),
    request("GB", "Q", "eng"),
    request("GB", "Go", "eng")
  )

  def main(args: Array[String]): Unit = {
    for (req <- requests){
      println(returnCorrectProposition(req.proposition))
    }
  }

  def returnCorrectProposition(key: String): String = {
    if (propositionMap.contains(key)) {
      propositionMap(key)
    } else {
      key
    }
  }
}