package either

import scala.language.postfixOps

object EitherOnObjectsExample extends App {

  val personWithNameAndAge = PersonUsingCompanionObject("Gurtrude", 408)
  println(personWithNameAndAge.toString)

  val personWithAgeOnly = PersonUsingCompanionObject(12)
  println(personWithAgeOnly.toString)

  val anotherPersonWithNameAndAge = PersonUsingCompanionObject("Barry", 17)
  println(anotherPersonWithNameAndAge.toString)

  println("Using Either on Objects")
  checkPerson(personWithAgeOnly)
  checkPerson(personWithNameAndAge)
  checkPerson(anotherPersonWithNameAndAge)

  def checkPerson(person: PersonUsingCompanionObject): Unit = {
    checkIfNameExists(person) match {
      case Left(s) => println(s)
      case Right(s) => println(s)
    }
  }

  def checkIfNameExists(person: PersonUsingCompanionObject): Either[String, String] = {
    if (person.name.equalsIgnoreCase("barry")) {
      Left("We don't want (%s) here".format(person.name))
    } else {
      Right("%s is a good person".format(person.name))
    }
  }
}