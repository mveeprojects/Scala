package basics

import scala.io.StdIn

object Getting_Console_Input {

  def main(args: Array[String]): Unit = {
    checkConsoleInput()
  }

  def checkConsoleInput(): Unit = {

    var playersGuess = 0
    var numberToGuess = 12

    do {
      print("Guess a number ")
      playersGuess = StdIn.readLine().toInt
    } while (playersGuess != numberToGuess)

    printf("You guessed the secret number! (%d)\n", numberToGuess)
  }
}
