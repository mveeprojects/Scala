name := "Scala"

version := "0.1"

lazy val akkaHttpVersion = "10.0.10"
lazy val akkaVersion = "2.5.4"
lazy val scalaLoggingVersion = "3.9.0"
lazy val logbackVersion = "1.2.3"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.mark.stuff",
      scalaVersion := "2.12.6"
    )),
    name := "aiengine",
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
      "ch.qos.logback" % "logback-classic" % logbackVersion,
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.0.1" % Test,
      "com.typesafe.akka" %% "akka-http-core" % "10.1.3",
      "net.ruippeixotog" %% "scala-scraper" % "2.1.0",
      "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.0"
    )
  )