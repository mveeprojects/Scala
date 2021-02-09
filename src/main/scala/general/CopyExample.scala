package general

case class Person(name: String, age: Int) {
  override def toString: String =
    s"$name is $age years old"
}

object CopyExample extends App {
  val person1 = Person("Mark", 32)
  val person2 = person1.copy(age = 33)

  println(person1.toString())
  println(person2.toString())
}
