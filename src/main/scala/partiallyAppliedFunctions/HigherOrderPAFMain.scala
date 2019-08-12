package partiallyAppliedFunctions

object HigherOrderPAFMain extends App {

//  exampleOne()
//  exampleTwo()
  exampleThree()

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

  def exampleThree(): Unit = {

    // wokring on an example of a HOF receiving a function, which is in turn used to determine which function to return

    // FCF
    val checkType = (x: Any) => x match {
      case _: Int => "integer"
      case _: String => "string"
      case _ => "unknown"
    }

    // returnable functions
    val intPlusOne = (i: Int) => s"${i + 1}"
    val stringPlusOne = (s: String) => s"$s plus 1"
    val unknownTypePlusOne = (_: Any) => "not an integer or string"

    // HOF
    val gimmeATypeToCheck = (x: Any, func: Any => String) => func(x) match {
      case "integer" => intPlusOne
      case "string" => stringPlusOne
      case "unknown" => unknownTypePlusOne
    }

    // PAF
    val typeChecker = gimmeATypeToCheck(_: Any, checkType)

    println(typeChecker(1234))
    println(typeChecker("Bananas"))
    println(typeChecker(true))
  }
}