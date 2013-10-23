package test.pcohen.compilerplugins

import scala.tools.nsc
import nsc.Global
import nsc.Phase
import nsc.plugins.Plugin
import nsc.plugins.PluginComponent

class MyCompilerPlugin(val global: Global) extends Plugin {

  val name = "demoplugin"
  val description = "Demo plugin"
  val components = List[PluginComponent](DemoComponent)

  private object DemoComponent extends PluginComponent {
    val global: MyCompilerPlugin.this.global.type = MyCompilerPlugin.this.global

    val runsAfter = List[String]("refchecks");

    val phaseName = "democompilerplugin"
    def newPhase(prev: Phase): Phase = new DemoPhase(prev)

    class DemoPhase(prev: Phase) extends StdPhase(prev) {
      override def name = MyCompilerPlugin.this.name

      def apply(unit: global.CompilationUnit) {
        println("======== Hello demo compiler plugin")
      }
    }
  }
}

