import _root_.org.mortbay.jetty.Connector
import _root_.org.mortbay.jetty.Server
import _root_.org.mortbay.jetty.webapp.WebAppContext
import org.mortbay.jetty.nio._

object Main {
  def main(args: Array[String]) {
    val server = new Server
    val scc = new SelectChannelConnector
    scc.setPort(8080)
    server.setConnectors(Array(scc))

    val domain = this.getClass.getProtectionDomain
    val location = domain.getCodeSource.getLocation

    val context = new WebAppContext()
    context.setServer(server)
    context.setContextPath("/")
    context.setWar(location.toExternalForm)

    server.addHandler(context)

    try {
      println(">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP")
      server.start()
      while (System.in.available() == 0) {
        Thread.sleep(5000)
      }
      server.stop()
      server.join()
    } catch {
      case exc : Exception => {
        exc.printStackTrace()
        System.exit(100)
      }
    }
  }
}
