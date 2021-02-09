package futures

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object TimingFutureExample extends App with LazyLogging {

  myFancyFunction()
  Thread.sleep(10)

  def myFancyFunction(): Unit = {
    val myFutureThing = Future {
      Random.nextInt(500)
    }

    myFutureThing.onComplete {
      case Success(value) =>
        val starttime = System.currentTimeMillis()
        println(s"value: $value")
        println(s"took ${System.currentTimeMillis() - starttime}ms to complete")
      case Failure(exception) =>
        println("damn")
    }
  }
}
