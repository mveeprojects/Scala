package alpakka.consumers

import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.Sink
import alpakka.conf.AlpConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}

object ConsumerSimpleMain extends App with AlpConfig with LazyLogging {

  val consumerSettings = ConsumerSettings(consumerConfig, new StringDeserializer, new ByteArrayDeserializer)
    .withBootstrapServers(bootstrapServer)
    .withGroupId("group1")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val consumerDone = Consumer
    .plainSource(consumerSettings, Subscriptions.topics(topic))
    .runWith(Sink.foreach(message => logger.info(s"*** Message offset: ${message.offset()} ***")))

  consumerDone.onComplete(_ => logger.info("Consumption complete"))
}
