package fileSearcher

import java.io.File

class Matcher(filter: String, val rootPath: String) {

  val rootIOObject: IOObject = FileConverter.convertToIOObject(new File(rootPath))

  def execute(): List[String] = {
    val matchedFiles = rootIOObject match {
      case file: FileObject if FilterChecker(filter).matchesWellReallyJustContains(file.name) => List(file)
      case directory: DirectoryObject => FilterChecker(filter).findMatchedFiles(directory.children)
      case _ => List()
    }
    matchedFiles.map(_.name)
  }
}

object Matcher {
  def apply(filter: String, rootPath: String): Matcher = new Matcher(filter, rootPath)
  def apply(filter: String): Matcher = new Matcher(filter, new File(".").getCanonicalPath)
}