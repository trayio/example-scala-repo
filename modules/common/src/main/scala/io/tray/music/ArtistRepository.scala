package io.tray.music

import java.time.LocalDate

trait ArtistRepository[F[_]] {
  def getByName(name: String): F[Artist]
}

object ArtistRepository {

  val data: Map[String, Artist] = Map(
    "Epica"    -> Artist("Epica", LocalDate.of(2023, 11, 1)),
    "Doja Cat" -> Artist("Doja Cat", LocalDate.of(2024, 1, 5)),
  )

}
