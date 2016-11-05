name := """app-backend"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  javaJdbc,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  cache,
  javaWs
)

routesGenerator := InjectedRoutesGenerator