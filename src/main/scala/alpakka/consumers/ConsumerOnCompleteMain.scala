package alpakka.consumers

import akka.Done
import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.Sink
import alpakka.conf.AlpConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ConsumerOnCompleteMain extends App with AlpConfig with LazyLogging {

  val consumerSettings = ConsumerSettings(consumerConfig, new StringDeserializer, new ByteArrayDeserializer)
    .withBootstrapServers(bootstrapServer)
    .withGroupId("group1")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val consumerFuture: Future[Done] = Consumer
    .committableSource(consumerSettings, Subscriptions.topics(topic))
    .map(msg => {
      println(s"message: ${msg.committableOffset.partitionOffset.offset}")
    })
    .runWith(Sink.ignore)

  consumerFuture.onComplete {
    case Success(_) =>
      logger.info("all messages consumed OK")
      system.terminate()
    case Failure(exception) =>
      logger.info(s"something went wrong \n $exception")
      system.terminate()
  }
}
