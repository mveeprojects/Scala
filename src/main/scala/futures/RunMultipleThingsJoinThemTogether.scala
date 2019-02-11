package futures

import java.lang.Thread._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps
import scala.util.Random

object RunMultipleThingsJoinThemTogetherMoreEfficiently extends App {
  val inputList = List(1, 2, 3)
  Future.sequence(inputList.map(CallAndReturnStatusCode.fireRequest))
    .foreach(res => println(s"Result: $res"))
  sleep(2000)
}

object RunMultipleThingsJoinThemTogether extends App {

  val res1 = CallAndReturnStatusCode.fireRequest(1)
  val res2 = CallAndReturnStatusCode.fireRequest(2)
  val res3 = CallAndReturnStatusCode.fireRequest(3)

  val result = for {
    r1 <- res1
    r2 <- res2
    r3 <- res3
  } yield r1 + r2 + r3

  result.foreach(res => println(s"Result: $res"))
  sleep(2000)
}

object CreateListOfIntsFromFutures extends App {
  val inputList = List(1, 2, 3)
  val statusCodes = getStatusCodeList
  Await.result(statusCodes, 1 seconds)
  statusCodes.foreach(sc => println(s"Status codes: $sc"))

  def getStatusCodeList: Future[List[Int]] = {
    Future.sequence(inputList.map(CallAndReturnStatusCode.fireRequest))
  }

  sleep(1000)
}

object CallAndReturnStatusCode {
  def fireRequest(i: Int): Future[Int] = Future {
    i * Random.nextInt(1000)
  }
}