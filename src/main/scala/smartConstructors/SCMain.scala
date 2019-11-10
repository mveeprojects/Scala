package smartConstructors

object SCMain extends App {

  val a: Either[String, EmailAddress] = EmailAddress("bob@bob.com")
  println(a)

  val b = EmailAddress("bob.com")
  println(b)
}
