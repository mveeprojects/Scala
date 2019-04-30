package pomtosbt

import scala.xml._

// This converts (only) the dependencies from a pom.xml file into the format required in a build.sbt file
// Code credit: https://stackoverflow.com/questions/15430346/how-could-i-convert-a-pom-xml-to-sbt-dependencies

object PomToSBT extends App {

  (XML.load("D:/Workspace/Scala/src/main/scala/pomtosbt/pom.xml") \\ "dependencies") \ "dependency" foreach ((dependency: Node) => {
    val groupId = (dependency \ "groupId").text
    val artifactId = (dependency \ "artifactId").text
    val version = (dependency \ "version").text
    val scope = (dependency \ "scope").text
    val artifactValName: String = artifactId.replaceAll("[-\\.]", "_")

    print("\"%s\" %% \"%s\" %% \"%s\"".format(artifactValName, groupId, artifactId, version))
    scope match {
      case "" => print(",\n")
      case _ => print(" %% \"%s\",\n".format(scope))
    }
    None
  })
}