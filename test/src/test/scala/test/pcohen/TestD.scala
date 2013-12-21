package test.pcohen

import scala.util.continuations._

class Ask {

   // The continuation
   var cont: Option[String => Unit] = None

   def ask(query:String):String @cps[Unit] = {
      shift {
         k: (String => Unit) =>
            // Make the continuation available for call
            cont = Some(k)
            // Display the query and then quit the continuation
            println(query)
         }
   }

   // Starts the DSL - basically a set of DSL rules
   // with ask and waiting for answer to continue
   def start(f: => Unit @cps[Unit])  = {
      reset {
         f
      }
   }

   // get back into the DSL flow by calling the stored continuation
   def answer(answer:String) = {
     if (!cont.isEmpty) cont.get(answer)
     //cont=None
   }
  
   def end = cont=None
}

class TestD extends App {
val a = new Ask

a start {
  val n = a ask "question 1"
  if (n == "yes") { // doSomething 
  }
  val name = a ask "Whats your name"
  println("Good bye "+name)
  a end
}
 
}

