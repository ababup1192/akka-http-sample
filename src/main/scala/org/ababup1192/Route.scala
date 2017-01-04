package org.ababup1192

import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._


trait Route {
  val routes =
    pathSingleSlash {
      get {
         complete("Hello World")
      }
    }

}
