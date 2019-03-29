package collections

object MapOnObjects extends App {

  val requests: List[MyRequest] = List(
    MyRequest("GB", "a_Prop", "eng"),
    MyRequest("GB", "b_Prop", "eng"),
    MyRequest("GB", "cProp", "eng")
  )

  val propositionMap: Map[String, String] = Map(
    "cProp" -> "c_Prop"
  )

  requests
    .map(checkRequestProposition)
    .foreach(req => println(req.proposition))

  def checkRequestProposition(request: MyRequest): MyRequest = {
    if (propositionMap.contains(request.proposition)) {
      request.copy(request.territory, propositionMap(request.proposition), request.language)
    } else {
      request
    }
  }
}

case class MyRequest(territory: String, proposition: String, language: String)