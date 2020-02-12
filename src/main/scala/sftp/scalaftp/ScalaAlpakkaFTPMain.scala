package sftp.scalaftp

import java.net.InetAddress
import java.nio.file.{Path, Paths}

import akka.actor.ActorSystem
import akka.stream.alpakka.ftp.{FtpCredentials, FtpSettings}
import akka.stream.alpakka.ftp.scaladsl.Ftp
import akka.stream.scaladsl.{FileIO, Sink}
import akka.stream.{ActorMaterializer, IOResult}

import scala.concurrent.{ExecutionContext, Future}


object ScalaAlpakkaFTPMain extends App {

  implicit val system: ActorSystem = ActorSystem("ftpActor")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materiiser: ActorMaterializer = ActorMaterializer()

  val credentials = FtpCredentials.create("mark","pass")
  val ftpSettings = FtpSettings(InetAddress.getByName("localhost")).withCredentials(credentials)
  val targetDir = Paths.get("/Users/mva13/workspace/ScalaFTP/target/")

  println("Starting")

  Ftp
    .ls("/", ftpSettings)
    .filter(ftpFile => ftpFile.isFile)
    .mapAsyncUnordered(parallelism = 5) { ftpFile =>
      val localPath: Path = targetDir.resolve("." + ftpFile.path)
      println(localPath.toString)
      val fetchFile: Future[IOResult] = Ftp
        .fromPath(ftpFile.path, ftpSettings)
        .runWith(FileIO.toPath(localPath))
      fetchFile.map { ioResult =>
        (ftpFile.path, ioResult)
      }
    }
    .runWith(Sink.seq)

  println("Stopping")
}