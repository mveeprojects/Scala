package mainConcepts.encapsulation

object Encapsulation {
  def main(args: Array[String]): Unit = {

    var animal = new Animal()
    println(animal.getSound)
    println(animal.toString)

    var anotherAnimal = new Animal("Bob", "boo")
    println(anotherAnimal.getSound)
    println(anotherAnimal.toString)
  }

  private class Animal(var name: String, var sound: String) {

    this.setName(name)

    val id: Int = Animal.newIdNumber

    def this(name: String){
      this("No name set", "No sound set")
      this.setName(name)
    }

    def this(){
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

  // static companion object
  private object Animal {
    private var idNumber = 0
    private def newIdNumber = {
      idNumber += 1
      idNumber
    }
  }
}