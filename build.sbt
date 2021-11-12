
ThisBuild / scalaVersion := "2.12.4"
ThisBuild / organization := "com.datastax"

lazy val hello = (project in file("."))
  .settings(
    name := "ConnectDb",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test,
    libraryDependencies += "com.datastax.oss" % "java-driver-core" % "4.13.0"
  )
