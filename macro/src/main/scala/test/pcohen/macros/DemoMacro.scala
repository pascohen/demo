package test.pcohen.macros

import scala.reflect.macros.BlackboxContext
import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

object demoMacro {
  def impl(c: BlackboxContext)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    println("===== Hello demo macro")
    
    annottees(0)
  }
}

class demomacroannotation extends StaticAnnotation {
  def macroTransform(annottees: Any*):Any = macro demoMacro.impl
}
