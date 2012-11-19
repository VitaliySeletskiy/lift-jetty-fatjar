import AssemblyKeys._

name := "lift-jetty-fatjar"

scalaVersion := "2.9.1"

unmanagedResourceDirectories in Compile += file("src/main/webapp")

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-webkit" % "2.4",
  "org.mortbay.jetty" % "jetty" % "6.1.26",
  "ch.qos.logback" % "logback-classic" % "0.9.26"
)

assemblySettings
