package akkahttp.di

import akkahttp.routes.AppRoutes

trait AppModules {

  import com.softwaremill.macwire._

  lazy val appRoutes: AppRoutes = wire[AppRoutes]

  lazy val routes = List(
    appRoutes
  )
}