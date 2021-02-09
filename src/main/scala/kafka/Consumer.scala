package kafka

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration
import java.util
import java.util.Properties
import scala.jdk.CollectionConverters.iterableAsScalaIterableConverter

object Consumer extends App {

  consumeFromKafka("marks-topic")

  def consumeFromKafka(topic: String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9093")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))
    while (true) {
      val record = consumer.poll(Duration.ofSeconds(1)).asScala
      for (data <- record.iterator)
        println(data.value())
    }
  }
}
