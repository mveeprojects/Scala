package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object RunOneTaskButDontBlock extends App {

  onCompleteExample()
  onSuccessOrFailureExample()
  forEachSuccessFailureExample()

  private def onCompleteExample(): Unit = {
    val myFuture = Future {
      println("Starting calculation")
      Thread.sleep(Random.nextInt(500))
      42
    }

    println("Before calculation")
    //  onComplete sets up the callback
    myFuture.onComplete {
      case Success(value) => println("Finally, the callback completed, the value is ... " + value)
      case Failure(e) => e.printStackTrace()
    }

    println("A ...")
    Thread.sleep(100)
    println("B ...")
    Thread.sleep(100)
    println("C ...")
    Thread.sleep(100)
    println("D ...")
    Thread.sleep(100)
    println("E ...")
    Thread.sleep(100)
    println("F ...")
    Thread.sleep(100)
  }

  private def onSuccessOrFailureExample(): Unit = {

    //    NB: Bear in mind that onSuccess and onFailure are deprecated as of scala 2.12.x
    //    use foreach instead as shown in forEachSuccessFailureExample() below
    //    https://viktorklang.com/blog/Futures-in-Scala-2.12-part-5.html

    val myFuture = Future {
      Thread.sleep(Random.nextInt(500))
      if (Random.nextInt(500) > 250) throw new Exception("Too slow") else 42
    }

    myFuture.onSuccess {
      case result => println(result)
    }

    myFuture.onFailure {
      case ex => println(s"Exception thrown -> ${ex.getMessage}")
    }

    Thread.sleep(1000)
  }

  private def forEachSuccessFailureExample(): Unit = {

    val myFuture = Future {
      Thread.sleep(Random.nextInt(500))
      if (Random.nextInt(500) > 250) throw new Exception("Too slow") else 42
    }

    myFuture.foreach(println)
    myFuture.failed.foreach(println)

    Thread.sleep(1000)
  }
}
