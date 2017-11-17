package sleon

import
  scala.util.{
    Try ⇒ sTry,
    Success ⇒ sSuccess,
    Failure ⇒ sFailure
  },
  scala.concurrent.{
    Future ⇒ sFuture,
    ExecutionContext ⇒ sExecutionContext,
    Promise ⇒ sPromise
  },
  _root_.akka.{
    stream ⇒ akka_stream,
    http ⇒ akka_http,
    actor ⇒ akka_actor,
    NotUsed ⇒ akNotUsed,
    Done ⇒ akDone
  },
  akka_stream.{
    Materializer ⇒ akMaterializer,
    ActorMaterializer ⇒ akActorMaterializer
  },
  akka_stream.scaladsl.{
    Source ⇒ akSource,
    Flow ⇒ akFlow,
    Sink ⇒ akSink
  },
  akka_http.scaladsl.{ Http ⇒ akHttp },
  akka_http.scaladsl.server.{
    Directives ⇒ akDirectives,
    Route ⇒ akRoute
  },
  akka_actor.{
    ActorSystem ⇒ akActorSystem
  }

package object akka {
  type Try[a] = sTry[a]
  val Try = sTry
  type Success[a] = sSuccess[a]
  val Success = sSuccess
  type Failure[a] = sFailure[a]
  val Failure = sFailure

  type Future[a] = sFuture[a]
  val Future = sFuture
  type Promise[a] = sPromise[a]
  val Promise = sPromise
  type ExecutionContext = sExecutionContext
  val ExecutionContext = sExecutionContext

  type Done = akDone
  val Done = akDone
  type NotUse = akNotUsed
  val NotUsed = akNotUsed

  type Source[a, b] = akSource[a, b]
  val Source = akSource
  type Flow[a, b, c] = akFlow[a, b, c]
  val Flow = akFlow
  type Sink[a, b] = akSink[a, b]
  val Sink = akSink

  type ActorSystem = akActorSystem
  val ActorSystem = akActorSystem

  type Materializer = akMaterializer
  type ActorMaterializer = akActorMaterializer
  val ActorMaterializer = akActorMaterializer

  val Http = akHttp
  type Directives = akDirectives
  val Directives = akDirectives
  type Route = akRoute
  val Route = akRoute

}
