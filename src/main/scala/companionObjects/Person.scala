package companionObjects

class Person(val name: String, val age: Int)

object Person {
  def apply(name: String): Person = Person(name, 0)

  def apply(name: String, age: Int): Person = new Person(name, age)

  def apply(age: Int): Person = new Person("no name set", age)
}

object Main extends App {
  val people: Seq[Person] = List(Person("Mark"), Person(32), Person("Mark", 32))

  people.foreach(p => println(p.name))
}
