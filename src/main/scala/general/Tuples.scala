package general

object Tuples extends App {

  tupleExample()
  tupleExampleWithNamedParams()

  def tupleExample(): Unit = {
    val tupleMarge = (103, "Marge Simpson", 10.50000)
    printf("%s owes us £%.2f\n\n", tupleMarge._2, tupleMarge._3)
    printTuple(tupleMarge)
  }

  def printTuple(tuple: (Int, String, Double)): Unit =
    tuple.productIterator.foreach {
      println
    }

  def tupleExampleWithNamedParams(): Unit = {
    val (name, age, p) = ("Markk", 322, Person("Mark", 32))
    println(p.toString())
    println(name)
    println(age)
  }
}
