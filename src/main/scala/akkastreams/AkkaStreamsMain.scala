package akkastreams

import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object AkkaStreamsMain extends App with ActorConfig {

  basicSinkSourceExample()
  sourceFlowSinkExample()

  def basicSinkSourceExample(): Unit = {
    val source = Source(1 to 10)
    val sink = Sink.fold[Int, Int](0)(_ + _)
    val runnableGraph: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)
    val sumResult: Future[Int] = runnableGraph.run()
    printFutureResult(sumResult)
  }

  def sourceFlowSinkExample(): Unit = {
    val result = Source(1 to 6)
      .map(multiplyByTwo)
      .filter(isDivisibleByThree)
      .toMat(Sink.fold[Int, Int](0)(_ + _))(Keep.right)
      .run()
    printFutureResult(result)
  }

  def multiplyByTwo(i: Int): Int = {
    i * 2
  }

  def isDivisibleByThree(i: Int): Boolean = {
    i % 3 match {
      case 0 => true
      case _ => false
    }
  }

  def printFutureResult(future: Future[Int]): Unit = {
    future.onComplete {
      case Success(value) => println(s"value: $value")
      case Failure(_) => println("something went wrong")
    }
  }
}