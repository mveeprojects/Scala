package json

import net.liftweb.json._

case class Message(fragmentType: String, uuid: String, localizableInformation: Seq[LocalizableInformation])
case class LocalizableInformation(language: String, title: String)

object JsonMain extends App {

  implicit val formats: DefaultFormats.type = DefaultFormats

  val originalMessage = "{\"fragmentType\":\"SERIES\", \"uuid\":\"1234\", \"localizableInformation\":[ {\"language\": \"eng\", \"title\": \"Game of Thrones\"} ]}"
  val updatedMessage = "{\"fragmentType\":\"SERIES\", \"uuid\":\"1234\", \"localizableInformation\":[ {\"language\": \"esp\", \"title\": \"Game of Thrones\"} ]}"

  val oldMessage = parse(originalMessage).extract[Message]
  val newMessage = parse(updatedMessage).extract[Message]

  compareAndAssert(oldMessage.localizableInformation.head.language, newMessage.localizableInformation.head.language)

  def compareAndAssert(oldVal: String, newVal: String): Unit = {
    if (oldVal != newVal) {
      println("old did not equal new")
    } else {
      println("old did equal new")
    }
  }
}