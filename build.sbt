import sbt.Keys._
import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

val classpathDependencies: String = "compile->compile;test->test;"

lazy val common = (project in file("modules/common"))
  .settings(
    name := "common",
    libraryDependencies ++= cats ++ testDependencies ++ circe ++ logging,
  )

lazy val catsEffectServer = (project in file("modules/cats-effect-server"))
  .settings(
    name := "cats-effect-server",
    libraryDependencies ++= catsEffect ++ http4s,
  )
  .dependsOn(common % classpathDependencies)

lazy val pekkoServer = (project in file("modules/pekko-server"))
  .settings(
    name := "pekko-server",
    libraryDependencies ++= pekko,
  )
  .dependsOn(common % classpathDependencies)

lazy val root = (project in file("."))
  .settings(
    name := "scala-interview-endpoints",
  )
  .aggregate(common, catsEffectServer, pekkoServer)
