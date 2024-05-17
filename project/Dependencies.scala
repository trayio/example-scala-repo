import sbt._

object Dependencies {

  val catsVersion = "2.10.0"
  val cats = Seq(
    "org.typelevel" %% "cats-core" % catsVersion,
  )

  val catsEffectVersion = "3.5.4"
  val catsEffect = Seq(
    "org.typelevel" %% "cats-effect" % catsEffectVersion,
  )

  val htps4sVersion = "0.23.27"
  val http4s = Seq(
    "org.http4s" %% "http4s-ember-server" % htps4sVersion,
    "org.http4s" %% "http4s-ember-client" % htps4sVersion,
    "org.http4s" %% "http4s-circe"        % htps4sVersion,
    "org.http4s" %% "http4s-dsl"          % htps4sVersion,
  )

  val logbackVersion = "1.5.6"
  val logback = Seq(
    "ch.qos.logback" % "logback-classic" % logbackVersion,
  )

  val munitVersion           = "0.7.29"
  val munitCatsEffectVersion = "1.0.7"
  val specs2Version          = "4.20.6"
  val scalacheckVersion      = "1.18.0"
  val testDependencies = Seq(
    "org.specs2"     %% "specs2-core"          % specs2Version          % Test,
    "org.specs2"     %% "specs2-matcher-extra" % specs2Version          % Test,
    "org.specs2"     %% "specs2-junit"         % specs2Version          % Test,
    "org.specs2"     %% "specs2-scalacheck"    % specs2Version          % Test,
    "org.specs2"     %% "specs2-cats"          % specs2Version          % Test,
    "org.scalacheck" %% "scalacheck"           % scalacheckVersion      % Test,
    "org.scalameta"  %% "munit"                % munitVersion           % Test,
    "org.typelevel"  %% "munit-cats-effect-3"  % munitCatsEffectVersion % Test,
  )

  val circeVersion = "0.14.7"
  val circe = Seq(
    "io.circe" %% "circe-core"    % circeVersion,
    "io.circe" %% "circe-parser"  % circeVersion % Test,
    "io.circe" %% "circe-generic" % circeVersion,
  )

  val jsoniterVersion = "2.28.5"
  val jsoniter = Seq(
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniterVersion,
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion,
  )

  val playJsonVersion = "2.10.5"
  val playJson = Seq(
    "com.typesafe.play" %% "play-json" % playJsonVersion,
  )

  val pekkoHttpVersion = "1.0.1"
  val pekko = Seq(
    "org.apache.pekko" %% "pekko-http"         % pekkoHttpVersion,
    "org.apache.pekko" %% "pekko-http-testkit" % pekkoHttpVersion % "test",
  )
}
