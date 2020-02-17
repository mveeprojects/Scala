package akkahttp.anotherexample.models

final case class Item(id: Long, quantity: Int)
final case class Order(items: List[Item])