package imageCompare

import java.awt.image.BufferedImage
import java.io.File
import java.text.DecimalFormat

import javax.imageio.ImageIO

case class ImageWithMeta(imageName: String, image: BufferedImage)

object ImageCompareService {

  def compare(): String = {
    checkDiffPercentage(getImages)
  }

  private def getImages: Seq[ImageWithMeta] = {
    val path = new File(getClass.getResource("/images").getPath)
    path
      .listFiles()
      .toSeq
      .map(_.getName)
      .map(fileName => ImageWithMeta(fileName, ImageIO.read(new File(s"$path/$fileName"))))
  }

  private def checkDiffPercentage(imageList: Seq[ImageWithMeta]): String = {
    val totalPixelCount = imageList.head.image.getWidth * imageList.head.image.getHeight
    var cumulativeDiff = 0
    for {y <- 0 until imageList.head.image.getHeight
         x <- 0 until imageList.head.image.getWidth} {
      if (isDifferentRGB(imageList.head.image, imageList(1).image, x, y)) {
        cumulativeDiff += 1
      }
    }
    formatResult(cumulativeDiff, totalPixelCount, imageList)
  }

  private def isDifferentRGB(imageA: BufferedImage, imageB: BufferedImage, x: Int, y: Int): Boolean = {
    if (imageA.getRGB(x, y) != imageB.getRGB(x, y)) true
    else false
  }

  private def formatResult(cumulativeDiff: Int, totalPixelCount: Int, imageList: Seq[ImageWithMeta]): String = {
    val df = new DecimalFormat("##0.00")
    val diff = df.format((cumulativeDiff * 100.0f) / totalPixelCount)
    s"There is a $diff% difference between the given images (${imageList.head.imageName} and ${imageList(1).imageName})"
  }
}