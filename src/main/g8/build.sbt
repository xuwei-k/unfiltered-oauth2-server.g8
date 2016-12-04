organization := "com.example"

name := "$name$"

version := "0.1.0-SNAPSHOT"

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

scalaVersion := "$scala_version$"

val unfilteredVersion = "$unfiltered_version$"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-oauth2" % unfilteredVersion,
  "net.databinder" %% "unfiltered-json4s" % unfilteredVersion
)
