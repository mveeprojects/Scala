package akkahttp.anotherexample.di

import akkahttp.anotherexample.routes.ItemRoutes
import akkahttp.anotherexample.services.FindItemService

trait AppModules {

  import com.softwaremill.macwire._

  lazy val findItemService: FindItemService = wire[FindItemService]
  lazy val itemRoutes: ItemRoutes           = wire[ItemRoutes]

  lazy val routes = List(
    itemRoutes
  )
}
