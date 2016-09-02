name := "APIFootballDraft"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.jsoup" % "jsoup" % "1.9.2",
  "org.scalaj" % "scalaj-http_2.11" % "2.3.0",
  "com.typesafe.play" % "play-json_2.11" % "2.5.4",
  "com.typesafe.play" % "play-functional_2.11" % "2.5.4",
  "commons-io" % "commons-io" % "2.5"
)
