package kafka.avro

import com.sksamuel.avro4s.FromRecord
import com.typesafe.scalalogging.LazyLogging
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration
import java.util.Properties
import scala.jdk.CollectionConverters._

object AvroConsumer extends App with LazyLogging {

  val kafkaUrl          = "localhost:9093"
  val schemaRegistryUrl = "http://localhost:8081"
  val topic: String     = "person-topic"
  val props: Properties = setupKafkaProps

  consumeFromKafka

  private def consumeFromKafka()(implicit personFromRecord: FromRecord[Person]) {
    val consumer: KafkaConsumer[String, GenericRecord] = new KafkaConsumer[String, GenericRecord](props)
    consumer.subscribe(List(topic).asJava)
    val records = consumer.poll(Duration.ofSeconds(1))
    logger.info(s"Received ${records.count()} records")

    records.iterator.asScala.foreach { record =>
      val genericPerson: GenericRecord = record.value
      val person: Person = Person(
        genericPerson.get("name").toString,
        genericPerson.get("age").asInstanceOf[Int]
      )
      logger.info("Person received:")
      logger.info(person.toString)
    }
  }

  private def setupKafkaProps = {
    val props: Properties = new Properties()
    props.put("bootstrap.servers", "localhost:9093")
    props.put("group.id", "person-consumer")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer")
    props.put("schema.registry.url", schemaRegistryUrl)
    props
  }
}
