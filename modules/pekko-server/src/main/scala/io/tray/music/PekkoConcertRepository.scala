package io.tray.music

import java.time.LocalDate
import scala.concurrent.Future
import scala.util.Random

class PekkoConcertRepository extends ConcertRepository[Future] {
  override def getLatestConcert(artist: String): Future[Concert] = {
    val year  = Random.nextInt(24) + 2000
    val month = Random.nextInt(12) + 1
    val day   = Random.nextInt(28) + 1
    Future.successful(Concert(artist, LocalDate.of(year, month, day)))
  }
}
