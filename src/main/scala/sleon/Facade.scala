package sleon

import
  scala.util.{ Success },
  scala.concurrent.{ Future },
  scala.concurrent.{ Promise, ExecutionContext },
  _root_.akka.stream.scaladsl.{ Sink, Flow },
  _root_.akka.stream.{ scaladsl ⇒ astream },
  _root_.akka.http.{ scaladsl ⇒ ahttp },
  _root_.akka.{ Done, NotUsed }

class Facade {

  def http: sleon.http.Server =
    new sleon.akka.Context
    with sleon.akka.HttpServer
    {
      import ExecutionContext.Implicits.global

      val handle: Flow[String, String, NotUsed] =
        Flow.fromFunction(str ⇒ str ++ s" yes ok at ${java.time.Instant.now.toString}")

      val dasmas: Future[Done] = {
        handle.alsoT
        ???
      }

      val dismissPromise = Promise[Done]()
      val dismiss = dismissPromise.future
          .map { r ⇒ println("dismiss completed"); r }

      val handle2: Flow[String, String, NotUsed] = {
        Flow.fromFunction { str ⇒
          dismissPromise.complete(Success(Done))
          str + "FUCK YOU"
        }
      }

    }

}
