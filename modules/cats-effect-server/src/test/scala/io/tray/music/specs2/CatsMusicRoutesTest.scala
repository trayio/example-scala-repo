package io.tray.music.specs2

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.tray.music.{Artist, CatsMusicRoutes}
import org.http4s.implicits.http4sLiteralsSyntax
import org.http4s.{Method, Request, Status}
import org.http4s.circe.CirceEntityCodec.circeEntityDecoder
import org.specs2.mutable.Specification

import java.time.LocalDate

class CatsMusicRoutesTest extends Specification {

  val routes = new CatsMusicRoutes().routes

  "Service" should {
    "fetch artist" in {
      val getArtist = Request[IO](Method.GET, uri"/artist/epica")
      val response  = routes.orNotFound(getArtist)

      val resolvedResponse = response.unsafeRunSync()
      resolvedResponse.status must beEqualTo(Status.Ok)
      resolvedResponse.as[Artist].unsafeRunSync() must beEqualTo(Artist("epica", LocalDate.of(2023, 11, 1)))
    }
  }

}
