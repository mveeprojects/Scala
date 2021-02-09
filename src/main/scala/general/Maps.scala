package general

import scala.collection.mutable

object Maps {

  val employees = Map(
    "Manager"   -> "Bob",
    "Secretary" -> "Linda"
  )

  val customers: mutable.Map[Int, String] = collection.mutable.Map(
    1 -> "Paul",
    2 -> "Deborah"
  )

  def main(args: Array[String]): Unit = {
    immutableMaps()
    mutableMaps()
  }

  def immutableMaps(): Unit = {
    if (employees.contains("Manager")) {
      printf("manager: %s\n", employees("Manager"))
    }
    print("\n")
  }

  private def mutableMaps(): Unit = {
    printf("Customer 1: %s\n", customers(1))
    printf("Customer 2: %s\n", customers(2))

    customers(1) = "Tom"
    customers(3) = "Sally"

    printMap(customers)
  }

  private def printMap(map: mutable.Map[Int, String]): Unit =
    for ((k, v) <- map)
      printf("%d: %s\n", k, v)
}
