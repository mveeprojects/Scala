package objectGeneration

object PersonOptionExample extends App {

  println("Objects with Companion Object Examples")
  val personWithNameOnly = PersonUsingCompanionObject("Mark")
  println(personWithNameOnly.toString)
  val arrayOfPeopleWithNamesOnly = Array(PersonUsingCompanionObject("Bob"), PersonUsingCompanionObject("Dave"))
  arrayOfPeopleWithNamesOnly.foreach(println)


  val personWithNameAndAge = PersonUsingCompanionObject("Gurtrude", 408)
  println(personWithNameAndAge.toString)

  val personWithAgeOnly = PersonUsingCompanionObject(12)
  println(personWithAgeOnly.toString)


  println("\nObjects using Case Class Examples")
  val person = PersonUsingCaseClass("Sally")
  println(person.toString)
}