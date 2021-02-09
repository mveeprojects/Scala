package alpakka.conf

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

trait AlpActorSystem {
  implicit val system: ActorSystem             = ActorSystem("my-alpakka")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor    = system.dispatcher
}
