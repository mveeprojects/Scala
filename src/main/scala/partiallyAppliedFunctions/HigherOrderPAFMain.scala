package partiallyAppliedFunctions

object HigherOrderPAFMain extends App {

  // create a 'first class' function
  val addTwoStrings = (a: String, b: String) => a.toInt + b.toInt

  // create a 'higher order' function
  val myHOFunc = (string1: String, string2: String, func: (String, String) => Int) => func(string1, string2)

  // create a 'partially applied' instance of the higher order
  val partiallyAppliedMyHOFunc = myHOFunc(_: String, _: String , addTwoStrings)

  // call the partially applied function
  println(partiallyAppliedMyHOFunc("12", "34"))
}