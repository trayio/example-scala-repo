package io.tray.music.scalatest

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.tray.music.{Artist, CatsMusicRoutes}
import org.http4s.implicits.http4sLiteralsSyntax
import org.http4s.{Method, Request, Status}
import org.http4s.circe.CirceEntityCodec.circeEntityDecoder
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

import java.time.LocalDate

class CatsMusicRoutesTest extends AsyncFlatSpec with Matchers {

  val routes = new CatsMusicRoutes().routes

  "Service" should "fetch artist" in {
    val getArtist = Request[IO](Method.GET, uri"/artist/epica")
    val response  = routes.orNotFound(getArtist)

    val resolvedResponse = response.unsafeRunSync()
    resolvedResponse.status shouldBe Status.Ok
    resolvedResponse.as[Artist].unsafeRunSync() shouldBe Artist("epica", LocalDate.of(2023, 11, 1))
  }

}
