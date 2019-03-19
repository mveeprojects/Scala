package couchbase

import com.couchbase.client.java.CouchbaseCluster
import com.couchbase.client.java.document.JsonDocument
import com.couchbase.client.java.document.json.JsonObject
import net.liftweb.json.Serialization.write
import net.liftweb.json._

case class Person(name: String, age: Int)

object CouchbaseMain extends App {

  implicit val formats: DefaultFormats.type = DefaultFormats

  val person1 = Person("mark", 32)

  val cluster = CouchbaseCluster.create("127.0.0.1")
  cluster.authenticate("admin", "password")
  val bucket = cluster.openBucket("testbucket")

  storePerson(person1)
  retrievePerson("101")

  def storePerson(person: Person): Unit = {
    val doc: JsonObject = JsonObject.fromJson(write(person))
    bucket.upsert(JsonDocument.create("101", doc))
  }

  def retrievePerson(_id: String): Person = {
    val result = bucket.get(_id)
    parse(result.content().toString).extract[Person]
  }
}