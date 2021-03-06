name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
   javaJpa,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.8.Final",
  "org.hibernate" % "hibernate-search" % "4.1.1.Final",
  "org.apache.commons" % "commons-email" % "1.3.3"
)

fork in run := true