package io.tray.music

import scala.concurrent.Future

class PekkoArtistRepository extends ArtistRepository[Future] {
  override def getByName(name: String): Future[Artist] = {
    ArtistRepository.data
      .get(name)
      .map(Future.successful)
      .getOrElse(Future.failed(new Exception(s"Artist $name not found")))
  }
}
