package sleon.akka

import
  sleon.http.Server,
  Directives._

trait HttpServer extends Server {
  this: Context ⇒
  import ExecutionContext.Implicits.global

  final val http = Http()

  /**
    * depends on [[handle]]
    * @return
    */
  final def route: Route = {
    val f: Future[String] = Source.single("REQUEST!").via(handle).runReduce(_ ++ _)
    onComplete(f) { repl ⇒ complete(repl) }
  }

  final def start: Unit =
    http
      .bindAndHandle(route, "localhost", 8080)
      .zip(dismiss)
      .foreach { _._1.unbind() }

}

