import scala.reflect.macros.BlackboxContext
import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

object demoMacroRoot {
  def impl(c: BlackboxContext)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    println("===== Hello demo macro root")
    
    annottees(0)
  }
}

class demomacrorootannotation extends StaticAnnotation {
  def macroTransform(annottees: Any*):Any = macro demoMacroRoot.impl
}
