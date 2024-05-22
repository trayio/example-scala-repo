package io.tray.music

import cats.effect.IO

class CatsArtistRepository extends ArtistRepository[IO] {
  override def getByName(name: String): IO[Artist] = {
    ArtistRepository.data
      .get(name)
      .map(IO.pure)
      .getOrElse(IO.raiseError(new Exception(s"Artist $name not found")))
  }
}
