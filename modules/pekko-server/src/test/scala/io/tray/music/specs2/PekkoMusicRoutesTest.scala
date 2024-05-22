package io.tray.music.specs2

import io.tray.music.{Artist, PekkoMusicRoutes}
import org.apache.pekko.http.scaladsl.model.StatusCodes.OK
import org.apache.pekko.http.scaladsl.testkit.Specs2RouteTest
import org.specs2.mutable.Specification
import org.apache.pekko.http.scaladsl.model.ContentTypes._
import Artist._
import com.github.pjfanning.pekkohttpcirce.ErrorAccumulatingCirceSupport._

import java.time.LocalDate

class PekkoMusicRoutesTest extends Specification with Specs2RouteTest {

  val routes = new PekkoMusicRoutes().routes

  "Service" should {
    "fetch artist" in {
      Get(s"/artist/epica") ~> routes ~> check {
        status shouldEqual OK
        contentType shouldEqual `application/json`
        responseAs[Artist] shouldEqual Artist("epica", LocalDate.of(2023, 11, 1))
      }
    }
  }
}
