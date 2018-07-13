package objectGeneration

case class PersonUsingCaseClass(var name: String) {

  override def toString: String = {
    "Name: %s".format(this.name)
  }
}