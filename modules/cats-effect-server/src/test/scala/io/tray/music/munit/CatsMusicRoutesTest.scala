package io.tray.music.munit

import io.tray.music.{Artist, CatsMusicRoutes}
import munit.CatsEffectSuite
import Artist._
import cats.effect.IO
import org.http4s.implicits.http4sLiteralsSyntax
import org.http4s.{Method, Request, Status}
import org.http4s.circe.CirceEntityCodec.circeEntityDecoder

import java.time.LocalDate

class CatsMusicRoutesTest extends CatsEffectSuite {

  val routes = new CatsMusicRoutes().routes

  test("Service should fetch artist") {
    val getArtist = Request[IO](Method.GET, uri"/artist/epica")
    val response  = routes.orNotFound(getArtist)
    assertIO(response.map(_.status), Status.Ok)
    assertIO(response.flatMap(_.as[Artist]), Artist("epica", LocalDate.of(2023, 11, 1)))
  }

}
