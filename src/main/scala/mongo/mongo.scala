package mongo

import org.mongodb.scala._

import scala.language.postfixOps

object mongo extends App {

  val mongoClient: MongoClient = MongoClient()
  val database: MongoDatabase = mongoClient.getDatabase("mydb")
  val collection: MongoCollection[Document] = database.getCollection("test");

  val document: Document = Document("_id" -> 1, "x" -> 1)

  val insertObservable: Observable[Completed] = collection.insertOne(document)

  insertObservable.subscribe(new Observer[Completed] {
    override def onNext(result: Completed): Unit = println(s"onNext: $result")
    override def onError(e: Throwable): Unit = println(s"onError: $e")
    override def onComplete(): Unit = println("onComplete")
  })

}

//  val collection: MongoCollection[Document] = db.getCollection("test")
//  prepareDB()
//
//  def prepareDB(): Unit = {
//    collection.drop()
//    insertTestDocuments()
//  }
//
//  def insertTestDocuments(): Unit = {
//    val documents: IndexedSeq[Document] = (1 to 100) map { i: Int => Document("i" -> i) }
//    val insertObservable = collection.insertMany(documents)
//    val insertAndCount = for {
//      insertResult <- insertObservable
//      countResult <- collection.countDocuments()
//    } yield countResult
//    println(s"total # of documents after inserting 100 small ones (should be 101):  $insertAndCount")
//  }