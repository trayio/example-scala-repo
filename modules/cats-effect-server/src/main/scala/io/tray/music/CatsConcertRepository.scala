package io.tray.music

import cats.effect.IO

import java.time.LocalDate
import scala.util.Random

class CatsConcertRepository extends ConcertRepository[IO] {
  override def getLatestConcert(artist: String): IO[Concert] = {
    val year  = Random.nextInt(24) + 2000
    val month = Random.nextInt(12) + 1
    val day   = Random.nextInt(28) + 1
    IO(Concert(artist, LocalDate.of(year, month, day)))
  }
}
