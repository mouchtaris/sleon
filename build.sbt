
lazy val sleon = project.in(file("."))
  .settings(
    name := "sleon",
    version := "0.1",
    scalaVersion := "2.12.4"
  )
  .settings(Akka.settings)
