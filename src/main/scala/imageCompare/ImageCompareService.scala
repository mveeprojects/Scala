package imageCompare

import java.awt.image.BufferedImage
import java.io.File

import com.typesafe.scalalogging.LazyLogging
import javax.imageio.ImageIO

object ImageCompareService extends LazyLogging {

  def compare(): Unit = {
    val imageMap = getImages
    if (imageMap.keys.toList.length != 2) {
      logger.error(s"Exactly two images are required in the resources/images directory, you have ${imageMap.keys.toList.length} images in this directory currently")
    }
    else if (!isHashCodeIdentical(imageMap)) {
      logger.info("Image hashcodes do not match")
      findDiff(imageMap)
    }
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

  private def isHashCodeIdentical(imageMap: Map[String, BufferedImage]): Boolean = {
    val buffImageList: Seq[BufferedImage] = imageMap.values.toList
    if (buffImageList.head.toString != buffImageList(1).toString) false
    else true
  }

  private def findDiff(imageMap: Map[String, BufferedImage]): Unit = {
    val imageNameList: Seq[String] = imageMap.keys.toList
    println(s"checking the difference between ${imageNameList.head} and ${imageNameList(1)}")

    // output could be a tuple of name, file, rgbarray[][]

  }
}