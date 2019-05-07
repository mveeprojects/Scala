package alpakka

import akka.kafka.scaladsl.Consumer
import akka.kafka.scaladsl.Consumer.DrainingControl
import akka.kafka.{ConsumerSettings, Subscriptions}
import akka.stream.scaladsl.{Keep, Sink}
import alpakka.common.AlpConfig
import com.typesafe.scalalogging.LazyLogging
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.{ByteArrayDeserializer, StringDeserializer}

object ConsumerMain extends App with AlpConfig with LazyLogging {

  val consumerSettings = ConsumerSettings(consumerConfig, new StringDeserializer, new ByteArrayDeserializer)
    .withBootstrapServers(bootstrapServer)
    .withGroupId("group1")
    .withProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

  val control = Consumer
    .plainSource(
      consumerSettings,
      Subscriptions.assignmentWithOffset(new TopicPartition("test-topic", 0), 0)
    )
    //    .mapAsync(1)(thing => logger.info(thing.toString))
    .toMat(Sink.seq)(Keep.both)
    .mapMaterializedValue(DrainingControl.apply)
    .run()
}
