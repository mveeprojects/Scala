package kafka

import org.apache.kafka.clients.producer._

import java.util.Properties

object Producer extends App {

  writeToKafka("marks-topic")

  def writeToKafka(topic: String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9093")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val record   = new ProducerRecord[String, String](topic, "key2", "value2")
    producer.send(record)
    producer.close()
  }
}
