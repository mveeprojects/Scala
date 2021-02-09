package partiallyAppliedFunctions

object AnotherPAFMain extends App {

  val wrapWithDiv = wrap("<div>")(_: String)("</div>")

  def wrap(htmlPrefix: String)(innerHTML: String)(htmlSuffix: String): Unit = println(
    htmlPrefix + innerHTML + htmlSuffix
  )

  wrapWithDiv("potato")
  wrapWithDiv("guppies")
}
