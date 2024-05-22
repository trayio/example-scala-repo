package io.tray.music

import cats.MonadThrow

import java.time.Instant
import java.time.temporal.ChronoField
import scala.util.{Failure, Random, Success, Try}

class TicketsProvider[F[_]: MonadThrow] {
  def getTickets(artist: String): Try[List[F[Int]]] = {
    val hourNow = Instant.now().get(ChronoField.HOUR_OF_DAY)
    if (hourNow > 17) {
      Failure(new Exception("Sorry, we are closed"))
    } else {
      Success((1 to Random.nextInt(10) + 1).map(MonadThrow[F].pure(_)).toList)
    }
  }
}
