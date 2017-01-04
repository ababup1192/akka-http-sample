package org.ababup1192

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.util.{Failure, Success}

object Boot extends App with Route {
  implicit lazy val system = ActorSystem("app-server")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val interface = "localhost"
  val port = 8080
  val logger = Logging(system, getClass)
  val binding = Http().bindAndHandle(routes, interface, port)

  binding onComplete {
    case Success(_) =>
      logger.info(s"Launch Server on $interface:$port")
    case Failure(err) =>
      logger.error(err, s"Failed to bind to $interface $port")
  }
}
