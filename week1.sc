object session {
  def abs(x: Double) = if (x < 0) -x else x

  def sqrt(x: Double) = {
    def sqrtInt(estimate: Double): Double =
      if (isGood(estimate)) estimate
      else sqrtInt(improve(estimate))

    def isGood(estimate: Double) =
      abs(estimate * estimate - x) / x < 0.001

    def improve(estimate: Double) =
      (estimate + x / estimate) / 2

    sqrtInt(1.0)

  }

}