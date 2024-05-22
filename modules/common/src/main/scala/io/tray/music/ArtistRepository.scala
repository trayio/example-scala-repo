package io.tray.music

import java.time.LocalDate

trait ArtistRepository[F[_]] {
  def getByName(name: String): F[Artist]
}

object ArtistRepository {

  val data: Map[String, Artist] = Map(
    "epica"    -> Artist("epica", LocalDate.of(2023, 11, 1)),
    "doja cat" -> Artist("Doja Cat", LocalDate.of(2024, 1, 5)),
  )

}
