package options

object EitherExample extends App {

  println(divideXByY(4, 2))
  println(divideXByY(12, 0))

  divideXByY(2, 0) match {
    case Left(s) => println(s)
    case Right(s) => println(s)
  }

  def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Cannot divide by 0")
    else Right(x / y)
  }
}