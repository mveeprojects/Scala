package MainConcepts.Traits

object Traits {

  def main(args: Array[String]): Unit = {
    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(1000))
  }

  trait Flyable {
    def fly: String
  }

  trait Bulletproof {
    def hitByBullet: String

    def ricochet(startSpeed: Double): String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }

  // can extend multiple traits using 'extends' and then 'with'
  // cannot extend more than 1 interface or abstract class
  class Superhero(val name: String) extends Flyable with Bulletproof {

    def fly: String = {
      "%s flys through the air".format(this.name)
    }

    override def hitByBullet: String = {
      "the bullet bounces off of %s".format(this.name)
    }
  }

}
