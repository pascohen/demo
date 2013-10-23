import sbt._
import Keys._

object DemoBuild extends Build {
    lazy val root = Project(id = "demo",
                            base = file(".")) aggregate(macro,compiler)

    lazy val macro = Project(id = "macro",
                           base = file("macro"))

    lazy val compiler = Project(id = "compiler-plugin",
                           base = file("compilerplugin"))
}
