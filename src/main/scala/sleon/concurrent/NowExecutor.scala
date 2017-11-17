package sleon
package concurrent

sealed trait NowExecutor
  extends AnyRef
  with ExecutionContext
  with lang.ImplicitlyAvailable
{

  final def execute(runnable: Runnable): Unit =
    Exception.nonFatalCatch.withTry {
      runnable.run()
    } match {
      case Failure(ex) ⇒ reportFailure(ex)
    }

  final def reportFailure(cause: Throwable): Unit =
    _root_.scala.concurrent.ExecutionContext.global.reportFailure(cause)

}

object NowExecutor extends NowExecutor
