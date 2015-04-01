package org.locationtech.sfcurve.hilbertCurve

import org.scalatest._

import org.locationtech.sfcurve.hilbert._;

class HilbertCurveSpec extends FunSpec with Matchers {

  val EPSILON: Double = 1E-3

  describe("A HilbertCurve implementation using UG lib") {

    it("translates (Double,Double) to Long and Long to (Double, Double)"){
      val sfc = HilbertCurve(20)
      val index = sfc.PointToValue(0.0,0.0)
      sfc.ValueToPoint(index) should be < (0.0, 0.0)
      sfc.ValueToPoint(index) should be > (-EPSILON, -EPSILON)
    }

    it("implements a range query"){

      val sfc = HilbertCurve(3)
      val range = sfc.RangeQuery(-178.123456, -86.398493, 179.3211113, 87.393483)

      range should have length 3
    }

  }
}
