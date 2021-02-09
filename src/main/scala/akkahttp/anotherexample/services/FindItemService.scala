package akkahttp.anotherexample.services

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akkahttp.anotherexample.models.Item

import scala.concurrent.{ExecutionContextExecutor, Future}

class FindItemService {

  implicit val system: ActorSystem                        = ActorSystem()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  implicit val materializer: ActorMaterializer            = ActorMaterializer()

  val orders: List[Item] = List(Item(1L, 1), Item(2L, 1), Item(3L, 1))

  def fetchItem(id: Long): Future[Option[Item]] = Future {
    orders.find(o => o.id == id)
  }
}
