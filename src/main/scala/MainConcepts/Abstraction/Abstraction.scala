package MainConcepts.Abstraction

object Abstraction {

  def main(args: Array[String]): Unit = {
    val fang = new Wolf("Fang")
    fang.moveSpeed = 36.0
    println(fang.move)
  }

  private abstract class Mammal(val name: String) {
    var moveSpeed: Double

    def move: String
  }

  private class Wolf(name: String) extends Mammal(name){
    override var moveSpeed: Double = 35.0

    override def move: String = {
      "The wolf %s runs %.2f mph".format(this.name, this.moveSpeed)
    }
  }
}