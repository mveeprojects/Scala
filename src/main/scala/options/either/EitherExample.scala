package options.either

import akka.http.scaladsl.model.{IllegalUriException, Uri}

import scala.language.postfixOps
import scala.util.Try

object EitherExample extends App {

  println("\nChecking division of numbers:")
  println(divideXByY(4, 2))
  println(divideXByY(12, 0))
  divideXByY(2, 0) match {
    case Left(s) => println(s)
    case Right(s) => println(s)
  }

  println("\nChecking URLs:")
  val urlBad = "http://abcd.com/this is not a good URL"
  val urlGood = "http://abcd.com/this_is_a_good_URL"

  checkUri(urlBad) match {
    case Left(s) => println(s)
    case Right(s) => println(s)
  }
  checkUri(urlGood) match {
    case Left(s) => println(s)
    case Right(s) => println(s)
  }

  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Cannot divide by 0")
    else Right(x / y)
  }

  def checkUri(uri: String): Either[String, String] = {
    Try {
      Uri(uri)
      Right("You entered a good URL")
    } recover {
      case e: IllegalUriException =>
        Left("You entered a bad URL, causing the following exception: \n" + e)
    }
  } get
}