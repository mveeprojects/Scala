package futures

import java.lang.Thread._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FunctionReturningFuture extends App {

  implicit val baseTime: Long = System.currentTimeMillis()

  def longRunningComputation(i: Int): Future[Int] = Future {
    sleep(100)
    i + 1
  }

  longRunningComputation(12).onComplete{
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => exception.printStackTrace()
  }

  List(
    longRunningComputation(12),
    longRunningComputation(13),
    longRunningComputation(14)
  ).foreach(_.onComplete{
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => exception.printStackTrace()
  })

  // keep the jvm from shutting down
  sleep(1000)
}