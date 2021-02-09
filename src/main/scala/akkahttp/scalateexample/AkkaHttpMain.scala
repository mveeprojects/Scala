package akkahttp.scalateexample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akkahttp.scalateexample.di.AppModules
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

object AkkaHttpMain extends AppModules with LazyLogging {

  implicit val system: ActorSystem                        = ActorSystem("my-actor-system")
  implicit val materializer: ActorMaterializer            = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  def main(args: Array[String]) {
    bind.onComplete {
      case Success(binding) =>
        println(s"App is running -> ${binding.localAddress}")
      case Failure(exception) =>
        println(s"App is dead -> ${exception.getMessage}")
        system.terminate()
    }
  }

  def bind: Future[Http.ServerBinding] =
    Http().bindAndHandle(allRoutes, appConfig.hostname, appConfig.port)
}
