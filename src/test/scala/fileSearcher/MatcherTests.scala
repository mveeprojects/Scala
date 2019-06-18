package fileSearcher

import java.io.File

import org.scalatest.FlatSpec

class MatcherTests extends FlatSpec {

  private val testDirectory: File = new File(getClass.getResource("/testdir/").getPath)

  "Given a file name that is matched by the given filter, the Matcher" should "return a list containing only that file name" in {
    val matcher = new Matcher("fake", "fakepath")
    val results = matcher.execute()
    assert(results == List("fakepath"))
  }

  "Given a real file with a name that is matched by the given filter, the Matcher" should "return a list with the name of that file" in {
    val matcher = Matcher("txt", testDirectory.getCanonicalPath)
    val results = matcher.execute()
    assert(results == List("test.txt"))
  }

  "Without passing the Matcher a path to check, the Matcher" should "default to using the current location" in {
    val matcher = Matcher("filter")
    assert(matcher.rootPath == new File(".").getCanonicalPath)
  }
}