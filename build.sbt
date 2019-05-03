name := "akka-simple-cluster-k8s"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.6"

resolvers += Resolver.bintrayRepo("tanukkii007", "maven")

enablePlugins(JavaServerAppPackaging, DockerPlugin)

val akkaVersion = "2.5.22"
val akkaHttpVersion = "10.1.5"
val akkaManagementVersion = "1.0.0"

libraryDependencies ++=Seq(
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-tools"     % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-metrics"   % akkaVersion,

  "com.typesafe.akka" %% "akka-discovery" % akkaVersion,
  "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % akkaManagementVersion,

  "com.lightbend.akka.management" %% "akka-management" % akkaManagementVersion,
  "com.lightbend.akka.management" %% "akka-management-cluster-http" % akkaManagementVersion,
  "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % akkaManagementVersion,

  "com.github.TanUkkii007" %% "akka-cluster-custom-downing" % "0.0.12",

  // api
  "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
)

dockerBaseImage := "openjdk:8"
dockerUsername := Some("softwaremill")
