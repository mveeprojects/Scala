package alpakka.consumers

import java.nio.charset.StandardCharsets

import akka.Done
import akka.kafka.scaladsl.Consumer
import akka.kafka.scaladsl.Consumer.DrainingControl
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.{Keep, Sink}
import alpakka.conf.AlpConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}

import scala.concurrent.Future

object ConsumerFutureDoneMain extends App with AlpConfig with LazyLogging {

  val consumerSettings = ConsumerSettings(consumerConfig, new StringDeserializer, new ByteArrayDeserializer)
    .withBootstrapServers(bootstrapServer)
    .withGroupId("group1")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

    Consumer
      .committableSource(consumerSettings, Subscriptions.topics(topic))
      .mapAsync(10) { msg =>
        saveToDB(msg.record.key, msg.record.value).map(_ => msg.committableOffset)
      }
      .toMat(Sink.seq)(Keep.both)
      .mapMaterializedValue(DrainingControl.apply)
      .run()

  def saveToDB(key: String, value: Array[Byte]): Future[Done] = Future {
    // put DB code here
    logger.info(s"message: ${new String(value, StandardCharsets.UTF_8)}")
    Done
  }
}