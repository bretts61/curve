resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Opts.resolver.sonatypeReleases,
  Resolver.mavenLocal
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
