package io.tray.music

import org.apache.pekko.http.scaladsl.marshalling.ToResponseMarshallable
import org.apache.pekko.http.scaladsl.server.Directives.pathPrefix
import org.apache.pekko.http.scaladsl.server.Route
import org.apache.pekko.http.scaladsl.model.StatusCodes._
import org.apache.pekko.http.scaladsl.server.Directives._
import io.circe.syntax._
import scala.concurrent.Future
import Artist._
import com.github.pjfanning.pekkohttpcirce.ErrorAccumulatingCirceSupport._
import scala.concurrent.ExecutionContext.Implicits.global

class PekkoMusicRoutes {

  private val repository: ArtistRepository[Future] = new PekkoArtistRepository

  val routes: Route =
    pathPrefix("artist") {
      (get & path(Segment)) { artist =>
        complete {
          repository.getByName(artist).map[ToResponseMarshallable] { artist =>
            OK -> artist.asJson
          }
        }
      }
    }

}
