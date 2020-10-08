package akkastreams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

import scala.concurrent.{ExecutionContextExecutor, Future}

// https://doc.akka.io/docs/akka/current/stream/stream-flows-and-basics.html
object BasicExampleMain extends App {

  implicit val system: ActorSystem = ActorSystem("akka-stream-basic-example")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val source = Source(1 to 3)
  val sink = Sink.fold[Int, Int](0)(_ + _)
  val runnableGraph: RunnableGraph[Future[Int]] = source.toMat(sink)(Keep.right)

  val result2 = source.runWith(sink)

  val result: Future[Int] = runnableGraph.run()
  // Alternatively you can omit the line above using runnableGraph and use runWith here instead
  // val result = source.runWith(sink)

  result.map(println)
}
