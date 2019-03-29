package functions

// "Higher order functions are functions that take at least one first class function as a parameter."
object HigherOrderFunctions extends App {

  private val str1 = "abc"
  private val str2 = "abc"

  def compareStringsDescending(string1: String, string2: String): Int = {
    if (string1 == string2) 0
    else if (string1 > string2) -1
    else 1
  }

  def compareStringsAscending(string1: String, string2: String): Int = {
    if (string1 == string2) 0
    else if (string1 > string2) 1
    else -1
  }

  // Higher order functions can return functions
  // e.g. this function returns a function that takes 2 strings and returns an Int -> (String, String) => Int
  def getComparator(reverse: Boolean): (String, String) => Int = {
    if (reverse) compareStringsDescending
    else compareStringsAscending
  }

  // The higher order function has now returned a function which we are assigning to a val (as a first class function)
  val returnedFunction: (String, String) => Int = getComparator(true)
  println(returnedFunction(str1, str2))
}