package io.tray.music

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto._

import java.time.LocalDate

final case class Artist(name: String, lastSeen: LocalDate)

object Artist {
  implicit val artistEncoder: Encoder[Artist] = deriveEncoder
  implicit val artistDecoder: Decoder[Artist] = deriveDecoder
}
