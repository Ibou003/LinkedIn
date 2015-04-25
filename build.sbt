name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "log4j" % "log4j" % "1.2.17",
  "org.apache.derby" % "derby" % "10.4.1.3",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.hibernate" % "hibernate-core" % "4.3.7.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.7.Final"
)

fork in run := true