package io.tray.music

import cats.effect.kernel.Resource
import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.implicits._
import org.http4s.server.middleware.Logger
import com.comcast.ip4s._
import io.tray.network.FreePort
import org.http4s.ember.server.EmberServerBuilder

object CatsMusicServer extends IOApp {

  private val routes  = (new CatsMusicRoutes().routes).orNotFound
  private val httpApp = Logger.httpApp(true, true)(routes)

  private val host = ipv4"0.0.0.0"
  private val port = Port.fromInt(FreePort.find).get

  override def run(args: List[String]): IO[ExitCode] = {
    (for {
      server <- EmberServerBuilder
        .default[IO]
        .withHost(host)
        .withPort(port)
        .withHttpApp(httpApp)
        .build
      _ <- Resource.eval(IO(println(s"👂 HTTP server listening on http://$host:$port")))
    } yield server).useForever
  }
}
