package partiallyAppliedFunctions

object HigherOrderPAFMain extends App {

  exampleOne()
  exampleTwo()

  def exampleOne(): Unit = {
    // create a 'first class' function
    val addTwoStrings = (a: String, b: String) => a.toInt + b.toInt

    // create a 'higher order' function
    val myHOFunc = (string1: String, string2: String, func: (String, String) => Int) => func(string1, string2)

    // create a 'partially applied function' based on the higher order function
    val partiallyAppliedMyHOFunc = myHOFunc(_: String, _: String, addTwoStrings)

    // call the partially applied function
    println(partiallyAppliedMyHOFunc("12", "34"))
  }

  def exampleTwo(): Unit = {
    // FCF
    val sayHelloFCF = (firstName: String, lastName: String) => s"Hi, my name is $firstName $lastName"

    // HOF
    val myHOFunc = (stringA: String, stringB: String, func: (String, String) => String) => func(stringA, stringB)

    // PAF
    val sayHiMyNameIs = myHOFunc(_: String, _: String, sayHelloFCF)

    println(sayHiMyNameIs("Mark", "Vallis"))
  }
}