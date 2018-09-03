package mainConcepts.traits.tutorialsPoint

object MyApplication {

  def main(args: Array[String]): Unit = {

    val myclass = new MyClass
    val somethingToSay = "hi my name is mark"

    myclass.sayHello()
    myclass.saySomething(somethingToSay)
    myclass.saySomethingElse(somethingToSay)
    myclass.saySomethingLoudly(somethingToSay)
  }
}