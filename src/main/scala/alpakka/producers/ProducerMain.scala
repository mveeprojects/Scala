package alpakka.producers

import akka.Done
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import alpakka.conf.AlpConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import scala.concurrent.Future

object ProducerMain extends App with AlpConfig with LazyLogging {

  val producerSettings = ProducerSettings(producerConfig, new StringSerializer, new StringSerializer)
    .withBootstrapServers(bootstrapServer)

  val producerDone: Future[Done] =
    Source(1 to 100)
      .map(_.toString)
      .map(value => new ProducerRecord[String, String](topic, value))
      .runWith(Producer.plainSink(producerSettings))

  producerDone.onComplete(_ => logger.info("all messages published"))
}