package futures

import java.lang.Thread._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object RunMultipleThingsJoinThemTogetherMoreEfficiently extends App {
  val inputList = List(1, 2, 3)
  Future.sequence(inputList.map(Cloud.runAlgorithm))
    .map(_.sum)
    .foreach(res => println(s"Result: $res"))
  sleep(2000)
}

object RunMultipleThingsJoinThemTogether extends App {

  val res1 = Cloud.runAlgorithm(1)
  val res2 = Cloud.runAlgorithm(2)
  val res3 = Cloud.runAlgorithm(3)

  val result = for {
    r1 <- res1
    r2 <- res2
    r3 <- res3
  } yield r1 + r2 + r3

  result.foreach(res => println(s"Result: $res"))
  sleep(2000)
}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    i * Random.nextInt(1000)
  }
}