package fold

import java.lang.Thread.sleep
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object FoldFutureExamples extends App {

  val numberList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

  val timesTwo: Int => Future[Int] = a =>
    Future {
      sleep(Random.nextInt(200))
      a * 2
    }

  val futureFold = Future.foldLeft(numberList.map(timesTwo(_)))(0) { case (acc, num) =>
    acc + num
  }

  futureFold.onComplete {
    case Success(value)     => println(value)
    case Failure(exception) => println(s"Exception caught: ${exception.getMessage}")
  }

  // keep the jvm from shutting down
  sleep(1000)
}

// foldLeft example from http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-foldLeft
object AllAboutScalaExample extends App {

  private val AVAILABLE_DONUT = "Vanilla donut"

  println("Step 1: Define a method which returns a Future Option")

  def donutStock(donut: String): Future[Option[Int]] = Future {
    println("checking donut stock")
    if (donut == AVAILABLE_DONUT) Some(10) else None
  }

  println(s"\nStep 2: Create a List of future operations")
  val futureOperations = List(
    donutStock("vanilla donut"),
    donutStock("plain donut"),
    donutStock("chocolate donut"),
    donutStock(AVAILABLE_DONUT)
  )

  println(s"\nStep 3: Call Future.foldLeft to fold over futures results from left to right")
  val futureFoldLeft = Future.foldLeft(futureOperations)(0) { case (acc, someQty) =>
    acc + someQty.getOrElse(0)
  }

  futureFoldLeft.onComplete {
    case Success(value)     => println(s"Result: $value")
    case Failure(exception) => println(s"Exception: ${exception.getMessage}")
  }

  // keep the jvm from shutting down
  sleep(1000)
}
