package akkahttp.routes

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import org.fusesource.scalate._

class AppRoutes {

  val templateEngine = new TemplateEngine()

  val baseRoute: Route =
    get {
      pathSingleSlash {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
      path("gimmehtml") {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, templateEngine.layout("views/index.scaml")))
      }
    }
}
