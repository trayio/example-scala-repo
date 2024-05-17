package io.tray.music

trait ConcertRepository[F[_]] {
  def getLatestConcert(artist: String): F[Concert]
  def saveConcert(concert: Concert): F[Unit]
}
