import
  sbt._,
  Keys._

object Akka {

  val Organisation = "com.typesafe.akka"

  val withTest: ModuleID ⇒ ModuleID = _ % Test

  val LibraryDependencies: Seq[ModuleID] =
    Seq(
      "stream" → ("2.5.6", withTest),
      "http" → ("10.0.10", withTest)
    )
    .map { case (name, (version, withTest)) ⇒
      withTest(Organisation %% s"akka-$name" % version)
    }

  val settings = Seq(
    libraryDependencies ++= LibraryDependencies
  )

}
