package Basics

object Conditional_and_Logical_Operators {

  var age = 0

  def main(args: Array[String]): Unit = {
    age = 21
    val canVote = ifElseExample()
    println("you " + canVote + " vote")
  }

  def ifElseExample(): String = {
    var result = ""
    if (age >= 18) {
      result = "can"
    } else if (age < 18 && age > 0) {
      result = "cannot"
    } else {
      result = "shouldn't"
    }
    result
  }
}