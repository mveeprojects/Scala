package objectGeneration

import scala.language.postfixOps

object PersonOptionExample extends App {

  println("Objects with Companion Object")
  val personWithNameOnly = PersonUsingCompanionObject("Mark")
  println(personWithNameOnly.toString)
  val arrayOfPeopleWithNamesOnly = Array(PersonUsingCompanionObject("Bob"), PersonUsingCompanionObject("Dave"))
  arrayOfPeopleWithNamesOnly.foreach(println)

  println("\nObjects using Case Class")
  val person = PersonUsingCaseClass("Sally")
  println(person.toString)
}