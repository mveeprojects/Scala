package smartConstructors

import org.scalatest.FunSuite

class EmailAddressTest extends FunSuite {

  test("Valid email address returns Right with EmailAddress instance") {
    val result: Either[String, EmailAddress] = EmailAddress("bob@bob.com")
    assert(result == EmailAddress("bob@bob.com"))
  }

  test("Invalid email address returns Left with String message") {
    val result: Either[String, EmailAddress] = EmailAddress("bob.com")
    assert(result == Left("Invalid email address"))
  }
}