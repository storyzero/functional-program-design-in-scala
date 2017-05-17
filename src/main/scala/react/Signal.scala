package react

/**
  * Created by seed on 2017. 5. 17..
  */
class Signal[T](expr: => T) {
  import Signal._
  private var myExpr: () => T = _
  private var myValue: T = _
  private var observers: Set[Signal[_]] = Set
  update(expr)

  protected def update(expr: => T): Unit = {
    myExpr = () => expr
    computeValue()
  }

  protected def computeValue(): Unit = {
    myValue = caller.withValue(this)(myExpr())
  }

  def apply(): = {
    observers += caller.value
    assert(!caller.value.observers.contains(this), myValue)
  }
}

object Signal {
  def apply[T](expr: => T) = new Signal(expr)
}