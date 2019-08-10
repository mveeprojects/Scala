package imageCompare

import java.awt.image.BufferedImage
import java.io.File
import java.text.DecimalFormat

import com.typesafe.scalalogging.LazyLogging
import javax.imageio.ImageIO

object ImageCompareService extends LazyLogging {

  def compare(): Unit = {
    val startTime = System.currentTimeMillis()
    logger.info("Starting image comparison")
    val imageMap = getImages
    if (imageMap.keys.toList.length == 2) {
      checkImageDimensions(imageMap)
      checkDiffPercentage(imageMap)
    }
    else {
      logger.error(s"Exactly two images are required in the resources/images directory, you have ${imageMap.keys.toList.length} images in this directory currently")
    }
    val endTime = System.currentTimeMillis()
    logger.info(s"Diff check took ${endTime - startTime}ms")
  }

  private def getImages: Map[String, BufferedImage] = {
    val path = new File(getClass.getResource("/images").getPath)
    path
      .listFiles()
      .toSeq
      .map(f => f.getName)
      .map(fileName => (fileName, ImageIO.read(new File(s"$path/$fileName"))))
      .toMap
  }

  private def checkImageDimensions(imageMap: Map[String, BufferedImage]): Unit = {
    logger.info("checking if image dimensions match")
    val buffImageList: Seq[BufferedImage] = imageMap.values.toList
    if ((buffImageList.head.getHeight != buffImageList(1).getHeight) || (buffImageList.head.getWidth != buffImageList(1).getWidth))
      logger.info("image dimensions are not the same")
    else
      logger.info("image dimensions are the same")
  }

  private def checkDiffPercentage(imageMap: Map[String, BufferedImage]): Unit = {
    val bothLists = imageMap.unzip

    val imageNameList: Seq[String] = bothLists._1.toSeq
    logger.info(s"checking the difference between ${imageNameList.head} and ${imageNameList(1)}")

    val imageList: Seq[BufferedImage] = bothLists._2.toSeq
    val totalPixelCount = imageList.head.getWidth * imageList.head.getHeight
    var cumulativeDiff = 0

    for (y <- 0 until imageList.head.getHeight) {
      for (x <- 0 until imageList.head.getWidth) {
        if (isDifferentRGB(imageList, x, y)) {
          cumulativeDiff += 1
        }
      }
    }

    val df = new DecimalFormat("##0.00")
    val diff = df.format(100 - (cumulativeDiff * 100.0f) / totalPixelCount)
    logger.info(s"% diff is $diff%")
  }

  private def isDifferentRGB(imageList: Seq[BufferedImage], x: Int, y: Int): Boolean = {
    if (imageList.head.getRGB(x, y) != imageList(1).getRGB(x, y)) true
    else false
  }
}