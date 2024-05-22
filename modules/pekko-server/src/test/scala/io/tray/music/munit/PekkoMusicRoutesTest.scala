package io.tray.music.munit

import io.tray.music.{Artist, PekkoMusicRoutes}
import org.apache.pekko.http.scaladsl.model.StatusCodes.OK
import munit.FunSuite
import org.apache.pekko.http.scaladsl.model.ContentTypes._
import Artist._
import com.github.pjfanning.pekkohttpcirce.ErrorAccumulatingCirceSupport._
import org.apache.pekko.http.scaladsl.server.ExceptionHandler
import org.apache.pekko.http.scaladsl.testkit.{RouteTest, TestFrameworkInterface}

import java.time.LocalDate

trait MUnitRouteTest extends TestFrameworkInterface with RouteTest { this: FunSuite =>
  override def failTest(msg: String): Nothing = {
    fail(msg)
  }

  override def testExceptionHandler: ExceptionHandler = ExceptionHandler { case e =>
    throw e
  }
}

class PekkoMusicRoutesTest extends FunSuite with MUnitRouteTest {

  val routes = new PekkoMusicRoutes().routes

  test("Service should fetch artist") {
    Get(s"/artist/epica") ~> routes ~> check {
      assertEquals(status, OK)
      assertEquals(contentType, `application/json`)
      assertEquals(responseAs[Artist], Artist("epica", LocalDate.of(2023, 11, 1)))
    }
  }

}
