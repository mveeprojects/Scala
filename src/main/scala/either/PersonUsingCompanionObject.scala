package either

class PersonUsingCompanionObject {

  var name: String = ""
  var age: Int = 0

  override def toString: String = {
    "Name: %s, Age: %d".format(this.name, this.age)
  }
}

object PersonUsingCompanionObject {

  def apply: PersonUsingCompanionObject = {
    var p = new PersonUsingCompanionObject
    p
  }

  def apply(name: String): PersonUsingCompanionObject = {
    var p = new PersonUsingCompanionObject
    p.name = name
    p
  }

  def apply(age: Int): PersonUsingCompanionObject = {
    var p = new PersonUsingCompanionObject
    p.age = age
    p
  }

  def apply(name: String, age: Int): PersonUsingCompanionObject = {
    var p = new PersonUsingCompanionObject
    p.name = name
    p.age = age
    p
  }
}