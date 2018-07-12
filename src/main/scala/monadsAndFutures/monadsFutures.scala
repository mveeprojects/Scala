package monadsAndFutures

object monadsFutures extends App {

  val maybeFirstName = Some("Mark")
  val maybeLastName = Some("Vallis")

  val maybeFullName = maybeFirstName.flatMap { firstName =>
    maybeLastName.map { lastName =>
      firstName + " " + lastName
    }
  }

  println(maybeFullName)
}