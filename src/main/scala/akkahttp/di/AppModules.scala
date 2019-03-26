package akkahttp.di

import akkahttp.conf.AppConfig
import akkahttp.routes.AppRoutes

trait AppModules {

  import com.softwaremill.macwire._

  lazy val appRoutes: AppRoutes = wire[AppRoutes]
  lazy val appConfig: AppConfig = wire[AppConfig]

  lazy val routes: List[AppRoutes] = List(
    appRoutes
  )
}