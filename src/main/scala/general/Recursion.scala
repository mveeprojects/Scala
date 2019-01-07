package general

object Recursion {

  def main(args: Array[String]): Unit = {
    val num = 5
    println("The factorial of " + num + " is: " + factorial(num))
  }

  def factorial(num: BigInt): BigInt = {
    if(num <= 1)
      1
    else
      num * factorial(num -1)
  }
}