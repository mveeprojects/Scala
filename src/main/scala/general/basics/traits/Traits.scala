package general.basics.traits

// Encapsulates method and field definitions
// Can be partially implemented, cannot have constructor parameters
// Classes can mix in any number of traits, rather than inheriting from only one superclass (interface)
// Child classes extending a trait can provide implementations for unimplemented methods in the trait

object Traits {

  def main(args: Array[String]): Unit = {
    val superman = new Superhero("Superman")
    println(superman.fly)
    println(superman.hitByBullet)
    println(superman.ricochet(1000))
  }

  private trait Flyable {
    def fly: String
  }

  private trait Bulletproof {
    def hitByBullet: String

    def ricochet(startSpeed: Double): String = {
      "The bullet ricochets at a speed of %.1f ft/sec".format(startSpeed * .75)
    }
  }

  // can extend multiple traits using 'extends' and then 'with'
  // cannot extend more than 1 interface or abstract class
  private class Superhero(val name: String) extends Flyable with Bulletproof {

    def fly: String = {
      "%s flys through the air".format(this.name)
    }

    override def hitByBullet: String = {
      "the bullet bounces off of %s".format(this.name)
    }
  }
}