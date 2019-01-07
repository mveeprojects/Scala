package general.basics.traits.tutorialsPoint

// All of the below can be overridden
// Forces you to override (implement) the saySomethingLoudly method and define its body
// var is accessible by classes, cannot be private
// setting var abstract enables easy manipulation per implementation, class just needs to implement it

trait MyTrait {

  private val suffix = "o"
  var prefix: String

  def sayHello(): Unit = println(prefix + " Hell" + suffix)

  // Defined method
  def saySomething(stuffToSay: String): Unit = println(stuffToSay)

  // Undefined method body
  def saySomethingElse(stuffToSay: String): Unit = {}

  // Undefined method body and return type
  def saySomethingLoudly(name: String)

}