package mainConcepts.traits.tutorialsPoint

// All of the below can be overridden
// Forces you to override (implement) the saySomethingLoudly method and define its body

trait MyTrait {

  def sayHello(): Unit = println("Hello")

  // Defined method
  def saySomething(stuffToSay: String): Unit = println(stuffToSay)

  // Undefined method body
  def saySomethingElse(stuffToSay: String): Unit = {}

  // Undefined method body and return type
  def saySomethingLoudly(name: String)

}