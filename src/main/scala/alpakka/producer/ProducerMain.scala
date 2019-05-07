package alpakka.producer

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import scala.concurrent.{ExecutionContextExecutor, Future}

object ProducerMain extends App with LazyLogging {

  implicit val system: ActorSystem = ActorSystem("alpakka-producer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher

  val config = system.settings.config.getConfig("akka.kafka.producer")
  val producerSettings = ProducerSettings(config, new StringSerializer, new StringSerializer)
    .withBootstrapServers("localhost:9093")

  val producerDone: Future[Done] =
    Source(1 to 100)
      .map(_.toString)
      .map(value => new ProducerRecord[String, String]("test-topic", value))
      .runWith(Producer.plainSink(producerSettings))

  producerDone.onComplete(_ => logger.info("all messages published"))
}