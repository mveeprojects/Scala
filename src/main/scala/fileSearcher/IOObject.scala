package fileSearcher

import java.io.File

trait IOObject {
  val file: File
  val name: String = file.getName
}

case class FileObject(file: File) extends IOObject
case class DirectoryObject(file: File) extends IOObject {
  def children: List[IOObject] =
    try
      file.listFiles().toList.map(FileConverter.convertToIOObject)
    catch {
      case _: NullPointerException => List()
    }
}