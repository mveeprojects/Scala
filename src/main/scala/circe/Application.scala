package circe

// JSON from: https://archive.org/metadata/Tech_News_Today_18

import io.circe._
import io.circe.generic.semiauto._
import io.circe.parser._

case class Meta(name: String, md5: String, length: String)

object Application extends App {

  implicit val fooDecoder: Decoder[Meta] = deriveDecoder
  implicit val fooEncoder: Encoder[Meta] = deriveEncoder

  val rawJson =
    """
    {
      "name": "tnt0018_h264b_864x480_500.mp4",
      "source": "original",
      "format": "MPEG4",
      "length": "2030.29",
      "mtime": "1346312012",
      "size": "143795208",
      "md5": "4e8384d1acb41b5040fdd8327df06c6c",
      "crc32": "fc0e388c",
      "sha1": "0a4fc76f9ea4321657131c0c2ae8df2db45e62ea",
      "height": "480",
      "width": "853"
    }
    """

  // Checking JSON is valid
  //  val parseResult: Either[ParsingFailure, Json] = parse(rawJson)
  //  parseResult match {
  //    case Left(_) => println("could not parse JSON")
  //    case Right(json) =>
  //      println(s"JSON: \n $json")
  //  }

  // Decoding to case class
  val result: Either[Error, Meta] = decode[Meta](rawJson)
  result match {
    case Left(ex) => println(s"Error creating case class: \n ${ex.getMessage}")
    case Right(meta) => println(s"${meta.name}, ${meta.md5}. ${meta.length}")
  }
}
