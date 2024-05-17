package io.tray.music

trait ArtistRepository[F[_]] {
  def getByName(name: String): F[Artist]
  def saveArtist(artist: Artist): F[Unit]
}
