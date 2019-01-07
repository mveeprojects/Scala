name := "scalaexamples"

version := "0.1"

scalaVersion := "2.12.6"

lazy val Basics = project
lazy val Maths = project
lazy val Encapsulation = project in file("general/basics")
lazy val Inheritance = project in file("general/basics")
lazy val Abstraction = project in file("general/basics")
lazy val Higher_Order_Functions = project in file("general/basics")