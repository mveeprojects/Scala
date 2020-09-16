package sealedTraits

object Main extends App {

  val skateboards: List[Skateboard] = List(
    TrickStick(8.25, 32.25),
    Cruiser(9.0, 33.15)
  )

  skateboards.foreach(sk => printSkateboard(sk))

  // [warn] /Users/mva13/workspace/MarkVee87/Scala/src/main/scala/sealedTraits/Main.scala:12:50: match may not be exhaustive.
  // [warn] It would fail on the following input: LongBoard(_, _)
  // [warn]   def printSkateboard(board: Skateboard): Unit = board match {
  // [warn]                                                  ^

  def printSkateboard(board: Skateboard): Unit = board match {
    case TrickStick(width, length) => println(s"Trickstick, width: $width, length: $length")
    case Cruiser(width, length) => println(s"Cruiser, width: $width, length: $length")
  }
}
