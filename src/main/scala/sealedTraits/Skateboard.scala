package sealedTraits

sealed trait Skateboard

case class TrickStick(width: Double, length: Double) extends Skateboard

case class Cruiser(width: Double, length: Double) extends Skateboard

case class LongBoard(width: Double, length: Double) extends Skateboard
