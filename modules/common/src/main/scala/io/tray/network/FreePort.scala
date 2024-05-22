package io.tray.network

import java.net.ServerSocket

object FreePort {

  def find: Int = {
    val server = new ServerSocket(0)
    val port   = server.getLocalPort
    server.close()
    port
  }

}
