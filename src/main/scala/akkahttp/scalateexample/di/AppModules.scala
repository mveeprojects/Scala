package akkahttp.scalateexample.di

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akkahttp.scalateexample.conf.AppConfig
import akkahttp.scalateexample.routes.{AppAdminRoutes, AppRoutes}

trait AppModules {

  import com.softwaremill.macwire._

  lazy val appRoutes: AppRoutes = wire[AppRoutes]
  lazy val appAdminRoutes: AppAdminRoutes = wire[AppAdminRoutes]
  lazy val appConfig: AppConfig = wire[AppConfig]

  lazy val allRoutes: Route = appRoutes.route ~ appAdminRoutes.route
}