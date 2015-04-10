name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  "org.apache.derby" % "derby" % "10.4.1.3",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final"
)

val appDependencies = Seq(
  "log4j" % "log4j" % "1.2.16"
) 