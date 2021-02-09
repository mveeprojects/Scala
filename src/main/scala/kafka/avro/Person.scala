package kafka.avro

import com.sksamuel.avro4s.{FromRecord, ToRecord}

case class Person(name: String, age: Int) {
  override def toString: String = {
    s"name: $name, age: $age"
  }
}

object Person {
  implicit val personToRecord: ToRecord[Person] = ToRecord[Person]
  implicit val personFromRecord: FromRecord[Person] = FromRecord[Person]
}
