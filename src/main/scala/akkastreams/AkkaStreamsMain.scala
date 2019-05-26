package akkastreams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Keep, RunnableGraph, Sink, Source}

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

object AkkaStreamsMain extends App {

  // provides the ActorSystem for the materializer
  implicit val system: ActorSystem = ActorSystem("my-akka-stream-actor-system")
  // provides the required resources (Actors) for the runnableGraph
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  // used for the execution/evaluation of the Future (onComplete)
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val source = Source(1 to 10)
  val sink = Sink.fold[Int, Int](0)(_ + _)
  val runnableGraph: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)

  val sumResult: Future[Int] = runnableGraph.run()

  sumResult.onComplete{
    case Success(value) => println(s"value: $value")
    case Failure(_) => println("something went wrong")
  }
}