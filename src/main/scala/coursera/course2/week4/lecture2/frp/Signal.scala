package coursera.course2.week4.lecture2.frp

import scala.util.DynamicVariable

class Signal[T](expr: => T) {

  import Signal._

  private var myExpr: () => T = _
  private var myValue: T = _
  private var observers: Set[Signal[_]] = Set()

  update(expr)

  protected def update(expr: => T): Unit = {
    myExpr = () => expr
    computeValue()
  }

  protected def computeValue(): Unit = {
    val newValue = caller.withValue(this)(myExpr())
    if (myValue != newValue) {
      myValue = newValue
      val obs = observers
      observers = Set()
      obs.foreach(_.computeValue())
    }
  }


  def apply(): T = {
    observers += caller.value
    assert(!caller.value.observers.contains(this), "cyclic signal definition")
    myValue
  }


}

object NoSignal extends Signal[Nothing](???) {
  override protected def computeValue(): Unit = ()
}

object Signal {
  /*
  Another Solution: Implicit Parameters
  Thread-local state still comes with a number of disadvantages:
  ▶ Its imperative nature often produces hidden dependencies which are
    hard to manage.
  ▶ Its implementation on the JDK involves a global hash table lookup,
    which can be a performance problem.
  ▶ It does not play well in situations where threads are multiplexed
    between several tasks.
   */
  private val caller = new DynamicVariable[Signal[_]](NoSignal)

  def apply[T](expr: => T) = new Signal(expr)
}
