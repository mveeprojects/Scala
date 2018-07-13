package options.either

import objectGeneration.PersonUsingCompanionObject

import scala.language.postfixOps
import scala.util.Try

object EitherOnObjectsExample {

  val personWithNameAndAge = PersonUsingCompanionObject("Gurtrude", 408)
  println(personWithNameAndAge.toString)

  val personWithAgeOnly = PersonUsingCompanionObject(12)
  println(personWithAgeOnly.toString)

  println("Using Either on Objects")
  checkPerson(personWithAgeOnly)
  checkPerson(personWithNameAndAge)

  def checkPerson(person: PersonUsingCompanionObject): Unit = {
    checkIfNameExists(person) match {
      case Left(s) => println(s)
      case Right(s) => println(s)
    }
  }

  def checkIfNameExists(person: PersonUsingCompanionObject): Either[String, String] = {
    Try {
      person.name
      Left("The given person has provided their name (%s)".format(person.name))
    } recover {
      case npe: NullPointerException =>
        Right("No name has been set for this person, the following exception was thrown: \n" + npe)
    } get
  }
}