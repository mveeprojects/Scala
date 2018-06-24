name := "scalaexamples"

version := "0.1"

scalaVersion := "2.12.6"

lazy val Basics = project
lazy val Maths = project
lazy val Encapsulation = project in file("MainConcepts")
lazy val Inheritance = project in file("MainConcepts")
lazy val Abstraction = project in file("MainConcepts")
lazy val Polymorphism = project in file("MainConcepts")
lazy val Higher_Order_Functions = project in file("MainConcepts")