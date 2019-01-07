package general.basics.inheritance

object Inheritance {

  def main(args: Array[String]): Unit = {

    val animal = new Animal()
    println(animal.toString + "\n")

    val dog = new Dog("DOG", "Woof", "Grrr")
    println(dog.toString)

    dog.name = "BARRY"
    println(dog.toString)
  }

  class Animal(name: String, sound: String) {

    val id: Int = Animal.newIdNumber

    def this(name: String) {
      this(name, "No sound set")
    }

    def this() {
      this("No name set", "No sound set")
    }

    override def toString: String = {
      "%s with id %d says %s".format(this.name, this.id, this.sound)
    }
  }

  object Animal {
    private var idNumber = 0

    private def newIdNumber = {
      idNumber += 1
      idNumber
    }
  }

  class Dog(var name: String, sound: String, growl: String) extends Animal(name, sound) {

    def this(name: String, sound: String) {
      this("No Name", sound, "No Growl")
    }

    def this(name: String) {
      this("No Name", "No Sound", "No Growl")
    }

    def this() {
      this("No Name", "No Sound", "No Growl")
    }

    override def toString: String = {
      "%s with id %d says %s or %s".format(this.name, this.id, this.sound, this.growl)
    }
  }
}