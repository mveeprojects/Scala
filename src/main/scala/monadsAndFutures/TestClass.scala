package monadsAndFutures

class testrun extends App {
  val bob = TestClass(1, "2")
}

class TestClass(a: Int, b: String) {

}

object TestClass {
  def apply(a: Int, b: String): TestClass = new TestClass(a, b)
}
