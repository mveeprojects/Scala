package examples

object PizzaWithBaconMain extends App {

  val pizzaList: List[String] = List("pepperoni", "hawaiian", "margherita")
  println(s"pizzaList: $pizzaList")

  val baconPizzaList: List[String] = pizzaList.map(_ + " with bacon")
  println(s"baconPizzaList: $baconPizzaList")
}