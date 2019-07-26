package tryCatch

import java.io.IOException

import com.typesafe.scalalogging.LazyLogging

object TryCatchMain extends App with LazyLogging {

  val mfw = new MyFilewriter

  try {
    mfw.writeToFile("hello")
    logger.info("Written to file successfully")
  } catch {
    case _: IOException => logger.error("something broke")
  }
}

class MyFilewriter {
  def writeToFile(text: String): Boolean = {

    val currentTime = System.currentTimeMillis()
    // sporadically breaking to reflect the joys of the real world
    if (currentTime % 2 == 0) {
      true
    } else {
      throw new IOException
    }
  }
}