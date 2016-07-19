object session {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtInt(estimate: Double, x: Double): Double =
    if (isGood(estimate, x)) estimate
    else sqrtInt(improve(estimate, x), x)

  def isGood(estimate: Double, x: Double) =
    abs(estimate * estimate - x)/x < 0.001

  def improve(estimate: Double, x: Double) =
    (estimate + x/estimate)/ 2

  def sqrt(x: Double) = sqrtInt(1.0, x)


}