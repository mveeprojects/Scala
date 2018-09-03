package mainConcepts.traits.tutorialsPoint

class MyClass extends MyTrait {

  override def saySomething(stuffToSay: String): Unit = println(stuffToSay.replaceAll("m", "s"))

  override def saySomethingElse(stuffToSay: String): Unit = println("something else")

  override def saySomethingLoudly(stuffToSay: String): Unit = println(stuffToSay.toUpperCase())
}