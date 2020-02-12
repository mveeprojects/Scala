name := "Scala"

version := "0.1"

lazy val akkaHttpVersion = "10.0.10"
lazy val akkaVersion = "2.5.22"
lazy val scalaLoggingVersion = "3.9.0"
lazy val logbackVersion = "1.2.3"
lazy val macwireVersion = "2.3.1"
lazy val circeVersion = "0.12.3"
val scalaCodeVersion = "2.12.6"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.mark",
      scalaVersion := scalaCodeVersion
    )),
    libraryDependencies ++= loggingDepenencies,
    libraryDependencies ++= akkaDependencies,
    libraryDependencies ++= testingDependencies,
    libraryDependencies ++= webScraperDependencies,
    libraryDependencies ++= mongoDependencies,
    libraryDependencies ++= couchbaseDependencies,
    libraryDependencies ++= jsonParseingDependencies,
    libraryDependencies ++= autowiringDependencies,
    libraryDependencies ++= scalatraDependencies,
    libraryDependencies ++= kafkaDependencies,
    libraryDependencies ++= alpakkaDependencies,
    libraryDependencies ++= circeDependencies
  )

val loggingDepenencies = Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion
)

val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-http-core" % "10.1.3"
)

val testingDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % Test
)

val webScraperDependencies = Seq(
  "net.ruippeixotog" %% "scala-scraper" % "2.1.0"
)

val mongoDependencies = Seq(
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.0"
)

val couchbaseDependencies = Seq(
  "com.couchbase.client" % "java-client" % "2.7.4"
)

val jsonParseingDependencies = Seq(
  "net.liftweb" %% "lift-json" % "3.1.0-M3"
)

val autowiringDependencies = Seq(
  "com.softwaremill.macwire" %% "macros" % macwireVersion,
  "com.softwaremill.macwire" %% "macrosakka" % macwireVersion,
  "com.softwaremill.macwire" %% "util" % macwireVersion,
  "com.softwaremill.macwire" %% "proxy" % macwireVersion
)

val scalatraDependencies = Seq(
  "org.scalatra.scalate" %% "scalate-core" % "1.9.1"
)

val kafkaDependencies = Seq(
  "org.apache.kafka" %% "kafka" % "2.1.0"
)

val alpakkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.22",
  "org.apache.kafka" % "kafka-clients" % "2.1.1",
  "org.scala-lang" % "scala-library" % scalaCodeVersion,
  "com.lightbend.akka" %% "akka-stream-alpakka-file" % "1.0-M1",
  "com.lightbend.akka" %% "akka-stream-alpakka-ftp" % "1.0-M1",
  "com.jcraft" % "jsch" % "0.1.55"
)

val circeDependencies = Seq(
  "io.circe" %% "circe-parser" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion
)