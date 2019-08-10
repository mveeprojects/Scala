package general

object Tuples {

  def main(args: Array[String]): Unit = {
    tupleExample()
  }

  def tupleExample(): Unit = {
    val tupleMarge = (103, "Marge Simpson", 10.50000)
    printf("%s owes us £%.2f\n\n", tupleMarge._2, tupleMarge._3)

    printTuple(tupleMarge)
  }

  def printTuple(tuple: (Int, String, Double)): Unit = {
    tuple.productIterator.foreach{println}
  }
}