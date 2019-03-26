package akkahttp.conf

import com.typesafe.config.ConfigFactory

class AppConfig {
  private val config = ConfigFactory.load("akkahttp.conf")
  val hostname: String = config.getString("myApp.hostname")
  val port: Int = config.getInt("myApp.port")
}