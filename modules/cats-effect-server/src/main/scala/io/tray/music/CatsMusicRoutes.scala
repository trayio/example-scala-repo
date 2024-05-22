package io.tray.music

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import Artist._
import org.http4s.circe.CirceEntityCodec.circeEntityEncoder

class CatsMusicRoutes {
  val artistRepository: CatsArtistRepository = new CatsArtistRepository()

  val routes: HttpRoutes[IO] = {
    val dsl = new Http4sDsl[IO] {}
    import dsl._
    HttpRoutes.of[IO] { case GET -> Root / "artist" / artist =>
      for {
        artist <- artistRepository.getByName(artist)
        resp   <- Ok(artist)
      } yield resp

    }
  }
}
