package examples

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global


object FlatMapMain extends App {

  def addTwo(n: Int): Future[Int] = Future {
    n + 2
  }

  def addTwoAddTwo(n: Int): Future[Int] =
    addTwo(n).flatMap {
      // flatmap ensures n is mapped to the new value of addTwo(n2)
      // then flattens the value out of the nested Future and returns is as a single Future
      n2 => addTwo(n2)
    }

  addTwoAddTwo(4).onComplete(x => println(x))
  Thread.sleep(100)
}