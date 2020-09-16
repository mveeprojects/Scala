package sftp.scalaftp

import java.io.{BufferedOutputStream, FileOutputStream, IOException}

import org.apache.commons.net.ftp._

import scala.collection.immutable


object ScalaFTPMain extends App {

  private val client = new FTPClient
  private val localPathPrefix = "target/"

  openFTPConnection()
  retrieveFiles(listFilesOnFTP(false))
  closeFTPConnection()

  private def openFTPConnection(): Unit = {
    try {
      client.connect("localhost")
      client.enterLocalPassiveMode()
      client.login("mark", "pass")
      println("*** Connected to FTP ***")
    } catch {
      case _: IOException => println("exception thrown trying to connect to FTP server")
    }
  }

  private def listFilesOnFTP(printFileNames: Boolean): Seq[FTPFile] = {
    val fileList: immutable.Seq[FTPFile] = client.listFiles().toList
    if (printFileNames) {
      fileList.foreach(println)
      println("Number of files in FTP server: " + fileList.length)
    }
    fileList
  }

  private def retrieveFiles(fileList: Seq[FTPFile]): Unit = {
    for (file <- fileList) {
      val out = new BufferedOutputStream(new FileOutputStream(localPathPrefix + file.getName))
      try {
        var result = client.retrieveFile(file.getName, out)
        if (result) {
          result = true
          println(localPathPrefix + file.getName)
        }
      } catch {
        case e: Exception =>
          println("error", e)
      } finally {
        if (out != null) out.close()
      }
    }
  }

  private def closeFTPConnection(): Unit = {
    client.disconnect()
    println("*** Disconnected from FTP ***")
  }
}