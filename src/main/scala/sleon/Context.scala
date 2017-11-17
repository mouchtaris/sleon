package sleon

trait Context {
  protected[this] val actorSystemName: String
  protected[this] val shutDownSignal: Future[Unit]

  final implicit lazy val actorSystem: ActorSystem = ActorSystem(actorSystemName)
  final implicit lazy val materializer: Materializer = ActorMaterializer()

  final lazy val shutDownComplete: Future[Unit] = {
    import concurrent.NowExecutor._
    shutDownSignal
      .flatMap { _ ⇒ actorSystem.terminate() }
      .map { _ ⇒ () }
  }

}

