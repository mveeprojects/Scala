package imageCompare

import com.typesafe.scalalogging.LazyLogging

object ICMain extends App with LazyLogging {
  val startTime = System.currentTimeMillis()
  logger.info("Starting image comparison")
  val result = ImageCompareService.compare()
  val endTime = System.currentTimeMillis()
  logger.info(s"Diff check took ${endTime - startTime}ms")
  logger.info(s"result: $result")
}