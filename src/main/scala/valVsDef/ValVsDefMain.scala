package valVsDef

object ValVsDefMain extends App {

  // different initialisation
  val myFilterConditionVal                  = (i: Int) => i % 2 == 0
  // same usage against collections
  val numberSeq = Seq(1, 2, 3, 4)

  def myFilterConditionDef(i: Int): Boolean = i % 2 == 0
  println(s"val version ${numberSeq.filter(myFilterConditionVal)}")
  println(s"def version ${numberSeq.filter(myFilterConditionDef)}")
}
