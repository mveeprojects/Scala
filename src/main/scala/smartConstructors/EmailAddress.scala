package smartConstructors

// sealed prevents anything outside of this file from creating subclasses of this (subverting our custom apply method)
// abstract removes the 'copy' method to ensure all instances are created via our apply method
sealed abstract case class EmailAddress(emailAddress: String)

// https://kleisli.io/use-smart-constructors-to-create-safe-apis/
object EmailAddress {

  private val EmailRegex =
    """(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""".r

  def apply(emailAddress: String): Either[String, EmailAddress] =
    if (isValidEmailAddr(emailAddress)) {
      Right(new EmailAddress(emailAddress) {})
    } else Left("Invalid email address")

  def isValidEmailAddr(str: String): Boolean =
    EmailRegex.findAllMatchIn(str).length == 1
}
