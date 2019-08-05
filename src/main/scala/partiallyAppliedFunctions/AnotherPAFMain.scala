package partiallyAppliedFunctions

object AnotherPAFMain extends App {

  def wrap(htmlPrefix: String)(innerHTML: String)(htmlSuffix: String): Unit = println(htmlPrefix + innerHTML + htmlSuffix)

  val wrapWithDiv = wrap("<div>")(_: String)("</div>")

  wrapWithDiv("potato")
  wrapWithDiv("guppies")
}