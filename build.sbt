lazy val sleon = project.in(file("."))
  .settings(
    name := "sleon",
    version := "0.1",
    scalaVersion := "2.12.4",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % "2.5.6",
      "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.6" % Test
    ),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.0.10",
      "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test
    )
  )
