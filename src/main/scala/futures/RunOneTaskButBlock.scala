package futures

import java.lang.Thread._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object RunOneTaskButBlock extends App {

  implicit val baseTime: Long = System.currentTimeMillis()

  val myFuture = Future {
    println("Starting calculation")
    sleep(1000)
    1 + 1
  }

  println("Before calculation")
//  Await will return with a java.util.concurrent.TimeoutException if the future does not return in the given duration (1 second)
  val result = Await.result(myFuture, 1.second)
  println(result)
  sleep(1000)
}
