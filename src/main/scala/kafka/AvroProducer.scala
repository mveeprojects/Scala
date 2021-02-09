package kafka

import com.sksamuel.avro4s.{AvroSchema, ToRecord}
import io.confluent.kafka.schemaregistry.client.{CachedSchemaRegistryClient, SchemaRegistryClient}
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig._
import io.confluent.kafka.serializers.KafkaAvroSerializer
import io.confluent.kafka.serializers.subject.TopicNameStrategy
import org.apache.avro.Schema
import org.apache.avro.generic._
import org.apache.kafka.clients.producer._
import org.apache.kafka.common.serialization.{Serializer => KafkaSerializer}

import java.util
import java.util.Properties
import scala.jdk.CollectionConverters._

case class Person(name: String, age: Int)

object Person {
  implicit val personToRecord: ToRecord[Person] = ToRecord[Person]
}

object AvroProducer extends App {
  val schemaRegistryUrl                        = "http://localhost:8081"
  val topic: String                            = "person-topic"
  val schema: Schema                           = AvroSchema[Person]
  val props: Properties                        = setupKafkaProps
  val kafkaAvroSerializer: KafkaAvroSerializer = configureSerializer
  val person: Person                           = Person("Mark", 21)

  writeToKafka(person)

  def writeToKafka(person: Person)(implicit personToRecord: ToRecord[Person]): Unit = {

    personSerializer((topic, person: Person) => kafkaAvroSerializer.serialize(topic, personToRecord.to(person)))

    val producer: KafkaProducer[String, GenericRecord] = new KafkaProducer[String, GenericRecord](props)

    val genericPerson: GenericRecord = new GenericData.Record(schema)
    genericPerson.put("name", person.name)
    genericPerson.put("age", person.age)

    producer.send(new ProducerRecord(topic, genericPerson))
    producer.close()
  }

  private def setupKafkaProps: Properties = {
    val props: Properties = new Properties()
    props.put("bootstrap.servers", "localhost:9093")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer")
    props.put("schema.registry.url", schemaRegistryUrl)
    props
  }

  private def configureSerializer: KafkaAvroSerializer = {
    val schemaRegistryClient: SchemaRegistryClient =
      new CachedSchemaRegistryClient(schemaRegistryUrl, 100)

    val serializerConf: util.Map[String, String] =
      Map(VALUE_SUBJECT_NAME_STRATEGY -> classOf[TopicNameStrategy].getName, SCHEMA_REGISTRY_URL_CONFIG -> "").asJava

    val kafkaAvroSerializer: KafkaAvroSerializer = new KafkaAvroSerializer(schemaRegistryClient)
    kafkaAvroSerializer.configure(serializerConf, false)
    kafkaAvroSerializer
  }

  private def personSerializer[Person](f: (String, Person) => Array[Byte]): KafkaSerializer[Person] =
    (topic: String, data: Person) => f(topic, data)
}
