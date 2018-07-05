package basics

object Conditional_and_Logical_Operators {

  var age = 0

  def main(args: Array[String]): Unit = {
    age = 17
    println("you " + (if (isOldEnough()) "can" else "cannot") + " vote")
  }

  def isOldEnough(): Boolean = {
    var result = false
    if (age >= 18) {
      result = true
    } else {
      result = false
    }
    result
  }
}