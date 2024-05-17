import sbt.Keys._
import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

val classpathDependencies: String = "compile->compile;test->test;"

lazy val common = (project in file("modules/common"))
  .settings(
    name := "common",
    libraryDependencies ++= cats ++ testDependencies ++ circe ++ playJson ++ jsoniter ++ logback,
  )

lazy val catsEffectTask = (project in file("modules/cats-effect-task"))
  .settings(
    name := "cats-effect-task",
    libraryDependencies ++= catsEffect ++ http4s,
  )
  .dependsOn(common % classpathDependencies)

lazy val pekkoTask = (project in file("modules/pekko-task"))
  .settings(
    name := "pekko-task",
    libraryDependencies ++= pekko,
  )
  .dependsOn(common % classpathDependencies)

lazy val root = (project in file("."))
  .settings(
    name := "scala-interview-endpoints",
  )
  .aggregate(catsEffectTask)
