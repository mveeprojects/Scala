package akkahttp.routes

import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.http.scaladsl.server.Route

class AppAdminRoutes {

  val route: Route =
    get {
      path("admin") {
        complete("this is the admin route")
      }
    }
}