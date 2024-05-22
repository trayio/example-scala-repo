package io.tray.music.scalatest

import io.tray.music.{Artist, PekkoMusicRoutes}
import org.apache.pekko.http.scaladsl.model.StatusCodes.OK
import org.apache.pekko.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.apache.pekko.http.scaladsl.model.ContentTypes._
import Artist._
import com.github.pjfanning.pekkohttpcirce.ErrorAccumulatingCirceSupport._

import java.time.LocalDate

class PekkoMusicRoutesTest extends AsyncFlatSpec with ScalatestRouteTest {

  val routes = new PekkoMusicRoutes().routes

  "Service" should "fetch artist" in {
    Get(s"/artist/epica") ~> routes ~> check {
      status shouldBe OK
      contentType shouldBe `application/json`
      responseAs[Artist] shouldBe Artist("epica", LocalDate.of(2023, 11, 1))
    }
  }

}
