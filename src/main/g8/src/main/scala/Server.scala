package $package$

import unfiltered.jetty._
import java.net.URL

object Server {

  def main(args: Array[String]) {
    val binding = SocketPortBinding(host = "localhost", port = $port$)
    unfiltered.jetty.Server.portBinding(binding)
      .resources(new URL(getClass.getResource("/web/robots.txt"), "."))
      .context("/oauth") {
        _.plan(unfiltered.oauth2.OAuthorization(AppAuth))
      }.context("/api") {
        _.plan(Api)
      }.plan(Authentication).run
  }
}
