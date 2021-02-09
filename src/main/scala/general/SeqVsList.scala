package general

import com.typesafe.scalalogging.LazyLogging

// Scala Seq == Java List
// Scala List == Java LinkedList
// https://stackoverflow.com/questions/10866639/difference-between-a-seq-and-a-list-in-scala
// https://danielasfregola.com/2015/06/15/which-immutable-scala-collection/

object SeqVsList extends App with LazyLogging {

  private val numberOfElements = 1234567

  // whichever of these is run first takes the most amount of time
  populateSeq()
  populateList()

  def populateSeq(): Unit = {
    val seqStartTime = System.currentTimeMillis()
    val aSeq         = Seq.fill(numberOfElements)("foo")
    logger.info(s"Populating Seq took ${System.currentTimeMillis() - seqStartTime} ms")
  }

  def populateList(): Unit = {
    val listStartTime = System.currentTimeMillis()
    val aList         = List.fill(numberOfElements)("bar")
    logger.info(s"Populating List took ${System.currentTimeMillis() - listStartTime} ms")
  }
}
