package sleon.akka

trait Context {

  implicit val actorSystem: ActorSystem =
    ActorSystem("SLeonSystems")

  implicit val materializer: Materializer =
    ActorMaterializer()

}

