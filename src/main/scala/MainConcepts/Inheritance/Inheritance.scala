package MainConcepts.Inheritance

object Inheritance {

  def main(args: Array[String]): Unit = {

    val animal = new Animal()
    println(animal.toString + "\n")

    val dog = new Dog("Barry", "Woof", "Grrr")
    println(dog.getName)

    dog.setName("Goatface")
    println(dog.getName)

    println(dog.toString)
  }

  class Animal(var name: String, var sound: String) {

    this.setName(name)

    val id: Int = Animal.newIdNumber

    def this(name: String) {
      this("No name set", "No sound set")
      this.setName(name)
    }

    def this() {
      this("No name set", "No sound set")
    }

    def getName: String = {
      name
    }

    def getSound: String = {
      sound
    }

    def setName(name: String): Unit = {
      if (!name.matches(".*\\d+.*")) {
        this.name = name
      } else {
        this.name = "No name set"
      }
    }

    def setSound(sound: String): Unit = {
      this.sound = sound
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

  class Dog(name: String, sound: String, growl: String) extends Animal(name, sound) {

    def this(name: String, sound: String) {
      this("No Name", sound, "No Growl")
      this.setName(name)
    }

    def this(name: String) {
      this("No Name", "No Sound", "No Growl")
      this.setName(name)
    }

    def this() {
      this("No Name", "No Sound", "No Growl")
    }

    override def toString: String = {
      "%s with id %d says %s or %s".format(this.getName, this.id, this.sound, this.growl)
    }
  }
}