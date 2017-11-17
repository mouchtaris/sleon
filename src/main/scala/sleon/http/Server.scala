package sleon.http

import
  scala.concurrent.{ Future },
  akka.stream.scaladsl.{ Flow },
  akka.{ Done, NotUsed }

trait Server {

  protected[this] def dismiss: Future[Done]

  protected[this] def handle: Flow[String, String, NotUsed]

  def start: Unit

}
