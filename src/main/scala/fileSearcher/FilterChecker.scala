package fileSearcher

class FilterChecker(filter: String) {
  def matchesWellReallyJustContains(content: String): Boolean = content.contains(filter)

  def findMatchedFiles(IOObjects: List[IOObject]): List[IOObject] =
    IOObjects
      .filter(_.isInstanceOf[FileObject])
      .filter(item => matchesWellReallyJustContains(item.name))
}

object FilterChecker {
  def apply(filter: String): FilterChecker = new FilterChecker(filter)
}