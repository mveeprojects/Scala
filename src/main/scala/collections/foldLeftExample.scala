package collections

object foldLeftExample extends App {

  val strs = List("item1" , "item2" , "item3" , "item4")

  val out : String = strs.foldLeft("")((acc, item) => {
    acc + item + "/"
  })

  val outResult: String = out.patch(out.lastIndexOf('/'), "", 1)
  println(outResult)
}