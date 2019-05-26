package akkastreams

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

trait ActorConfig {
  // provides the ActorSystem for the materializer
  implicit val system: ActorSystem = ActorSystem("my-akka-stream-actor-system")
  // provides the required resources (Actors) for the runnableGraph
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  // used for the execution/evaluation of the Future (onComplete)
  implicit val ec: ExecutionContextExecutor = system.dispatcher
}