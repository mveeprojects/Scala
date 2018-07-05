package maths

import scala.math._

object Maths {

  def main(args: Array[String]): Unit = {
    val a = 3
    val b = 9
    println(a + "+" + b + "=" + addition(a, b))
    println("the remainder of " + b + "/" + a + " is " + modulus(a,b))
    roundUp(4.7)
    printBigInt()
    printBigDouble()
  }

  def addition(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }

  def modulus(a: Int, b: Int): Int = {
    var remainder: Int = 0
    remainder = b % a
    remainder
  }

  def roundUp(a: Double): Unit = {
    val result = round(a)
    println(a + " rounded up = " + result)
  }

  def printBigInt(): Unit = {
    val largeInteger = BigInt("31511641313516531684864351354131351313813813818196161351")
    println("BigInts can hold massive integer numbers e.g. " + largeInteger)
  }

  def printBigDouble(): Unit = {
    val largeDouble = BigDecimal("3.1511641313516531684864351354131351313813813818196161351")
    println("BigDoubles can hold massive decimal numbers e.g. " + largeDouble)
  }
}
