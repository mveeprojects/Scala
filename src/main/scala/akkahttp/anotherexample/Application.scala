package akkahttp.anotherexample

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akkahttp.anotherexample.di.AppModules
import com.typesafe.config.Config

import scala.concurrent.Future
import scala.util.{Failure, Success}

object Application extends AppModules {

  implicit val system: ActorSystem = ActorSystem()

  import system.dispatcher

  val config: Config                           = system.settings.config
  implicit val materialiser: ActorMaterializer = ActorMaterializer()

  def main(args: Array[String]): Unit =
    bind().onComplete {
      case Success(binding) =>
        val localAddress = binding.localAddress
        println(
          s"${config.getString("app.appName")} is running at http://${localAddress.getHostName}:${localAddress.getPort}"
        )
      case Failure(exception) =>
        println(
          s"${config.getString("app.appName")} failed to start, the following exception was thrown:\n\n$exception"
        )
        system.terminate()
    }

  def bind(): Future[Http.ServerBinding] =
    Http().bindAndHandle(itemRoutes.route, config.getString("app.host"), config.getInt("app.port"))
}
