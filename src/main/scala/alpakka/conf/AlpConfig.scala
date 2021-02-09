package alpakka.conf

import com.typesafe.config.Config

trait AlpConfig extends AlpActorSystem {
  val generalConfig: Config  = system.settings.config.getConfig("akka.kafka")
  val producerConfig: Config = system.settings.config.getConfig("akka.kafka.producer")
  val consumerConfig: Config = system.settings.config.getConfig("akka.kafka.consumer")
  val bootstrapServer =
    s"${generalConfig.getString("bootstrapServerHost")}:${generalConfig.getString("bootstrapServerPort")}"
  val topic: String = generalConfig.getString("topic")
}
