package akkastreams

import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object AkkaStreamsMain extends App {
  BasicStuff.basicSinkSourceExample()
  StartingWithFlows.sourceFlowSinkExample()
}

object BasicStuff extends ActorConfig {

  def basicSinkSourceExample(): Unit = {
    val source = Source(1 to 10)
    val sink = Sink.fold[Int, Int](0)(_ + _)
    val runnableGraph: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)
    val sumResult: Future[Int] = runnableGraph.run()
    Utils.printFutureResult(sumResult, this.getClass.getSimpleName)
  }
}

object StartingWithFlows extends ActorConfig {

  def sourceFlowSinkExample(): Unit = {
    val result = Source(1 to 6)
      .map(multiplyByTwo)
      .filter(isDivisibleByThree)
      .toMat(Sink.fold[Int, Int](0)(_ + _))(Keep.right)
      .run()
    Utils.printFutureResult(result, this.getClass.getSimpleName)
  }

  private def multiplyByTwo(i: Int): Int = {
    i * 2
  }

  private def isDivisibleByThree(i: Int): Boolean = {
    i % 3 match {
      case 0 => true
      case _ => false
    }
  }
}

object Utils extends ActorConfig {

  def printFutureResult(future: Future[Int], ref: String): Unit = {
    future.onComplete {
      case Success(value) => println(s"value from ${formatClassName(ref)}: $value")
      case Failure(_) => println("something went wrong")
    }
  }

  private def formatClassName(str: String): String = {
    str.replace("$", "")
  }
}