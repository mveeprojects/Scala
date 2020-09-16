package zzandbox

object Main extends App {
  val person = new Person("mark", "v", 33)
  println(person.firstName)
  println(person.lastName)
  println(person.toString)
}

class Person(val firstName: String, val lastName: String, age: Int) {
  override def toString: String = s"$firstName $lastName, age: $age"
}
