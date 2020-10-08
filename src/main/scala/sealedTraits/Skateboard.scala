package sealedTraits

sealed trait Skateboard

case class TrickStick(width: Double, length: Double, name: String = "TrickStick") extends Skateboard

case class Cruiser(width: Double, length: Double, name: String = "Cruiser") extends Skateboard

case class LongBoard(width: Double, length: Double, name: String = "LongBoard") extends Skateboard
