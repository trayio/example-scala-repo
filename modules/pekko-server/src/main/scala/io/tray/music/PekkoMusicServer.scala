package io.tray.music

import com.typesafe.scalalogging.LazyLogging
import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object PekkoMusicServer extends App with LazyLogging {
  implicit val actorSystem: ActorSystem   = ActorSystem()
  implicit val executor: ExecutionContext = actorSystem.dispatcher

  private val musicRoutes: Route = new PekkoMusicRoutes().routes
  private val host               = "0.0.0.0"
  private val port               = 9000

  Http().newServerAt(host, port).bindFlow(musicRoutes).onComplete[Unit] {
    case Success(_) =>
      logger.info(s"👂 HTTP server listening on http://$host:$port")
    case Failure(exception) =>
      logger.error(s"⚠️ Error starting up the server:")
      logger.error(exception.getMessage)
      exception.printStackTrace()
      val _ = actorSystem.terminate()
  }

}
