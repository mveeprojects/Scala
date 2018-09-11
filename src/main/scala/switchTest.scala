object switchTest extends App {

    val name = "a"

    val aVal = name match {
      case "a" => 115200
      case "b" => 1645
      case "c" => 2029
    }

    println(aVal)
}