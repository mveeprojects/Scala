package apply

case class ApplyClass() {
  def apply(qty: Int): Unit = println(qty)
}

object Main extends App {
  List(
    ApplyClass(),
    ApplyClass(),
    ApplyClass()
  ).foreach(_(12))
}