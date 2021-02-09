package fold

// https://commitlogs.com/2016/09/10/scala-fold-foldleft-and-foldright/
// in the case of Option the value in the initial brackets is returned if the Option returns with None

object FoldOptionExamples extends App {

  val opt1: Option[Int] = Some(5)
  println(opt1.fold(0)(_ + 1)) // 6

  val opt2: Option[Int] = None
  println(opt2.fold(0)(_ + 1)) // 0

}
