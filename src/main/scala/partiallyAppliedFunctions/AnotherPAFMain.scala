package partiallyAppliedFunctions

object AnotherPAFMain extends App {

  def wrap(htmlPrefix: String)(innerHTML: String)(htmlSuffix: String): Unit = println(htmlPrefix + html + htmlSuffix)

  val html = "hi there"
  wrap("<p>")(html)("</p>")
  wrap("<div>")(html)("</div>")
}