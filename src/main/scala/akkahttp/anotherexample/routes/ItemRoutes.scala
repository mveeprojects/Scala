package akkahttp.anotherexample.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akkahttp.anotherexample.di.AppModules
import akkahttp.anotherexample.models.Item
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write

import scala.concurrent.Future

class ItemRoutes extends AppModules {

  implicit val formats: DefaultFormats.type = DefaultFormats

  val route: Route =
    get {
      pathPrefix("item" / LongNumber) { id =>
        val maybeItem: Future[Option[Item]] = findItemService.fetchItem(id)
        onSuccess(maybeItem) {
          case Some(item) => complete(write(item))
          case None       => complete(StatusCodes.NotFound)
        }
      }
    } ~ get {
      pathSingleSlash {
        getFromResource("web/index.html")
      }
    }
}
