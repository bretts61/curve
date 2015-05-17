package org.locationtech.sfcurve.hilbert

import org.scalatest._

import org.locationtech.sfcurve.hilbert._

class HilbertCurveSpec extends FunSpec with Matchers {

  val EPSILON: Double = 1E-3

  describe("A HilbertCurve implementation using UG lib") {

    it("translates (Double,Double) to Long and Long to (Double, Double)"){
      val resolution = 16
      val gridCells = math.pow(2, resolution)

      val sfc = new HilbertCurve2D(resolution)
      val index: Long = sfc.toIndex(0.0, 0.0)

      val xEpsilon = (360.0 / gridCells)
      val yEpsilon = (180.0 / gridCells)

      val point = sfc.toPoint(index)

      point._1 should be (-(xEpsilon / 2.0) +- 0.000001)
      point._2 should be (-(yEpsilon / 2.0) +- 0.000001)
    }

    it("implements a range query"){

      val sfc = new HilbertCurve2D(3)
      val range = sfc.toRanges(-178.123456, -86.398493, 179.3211113, 87.393483)

      range should have length 3
    }

    it("Takes a Long value to a Point (Double, Double)"){

      val value = 0L
      val sfc = new HilbertCurve2D(8)
      val point: (Double, Double) = sfc.toPoint(value)
      print(point)

    }

    it("Takes a Point (Double, Double) to a Long value"){

      val sfc = new HilbertCurve2D(8)
      val value: Long = sfc.toIndex(0.0,0.0)
      print(value)

    }

    it("Number of ranges in HilbertResolution"){

        println()
        var x = 10
      while(x != 20){
          val sfc = new HilbertCurve2D(x)
          val ranges = sfc.toRanges(-180, 89.68103, -179.597625, 90)
          println("HilbertResolution"+x+": "+ranges.size)
          x += 1
      }

    }
    it("Number of ranges in HilbertMediumResolution"){

        println()
        var x = 10
      while(x != 20){
          val sfc = new HilbertCurve2D(x)
          val ranges = sfc.toRanges(-180, 82.689749, -171.408692, 90)
          println("HilbertMediumResolution"+x+": "+ranges.size)
          x += 1
      }

    }
    it("Number of ranges in sfseize HilbertHalfBoundary"){
        println()
        var i = 10
        while(i != 20){
            val precision = math.pow(2, i)
            val sfc = CompactHilbertCurve(OrdinalVector(i, i))
            val query = Query(Seq(
                OrdinalRanges(OrdinalPair(i/4, i/4)),
                OrdinalRanges(OrdinalPair(i*3/4, i*3/4))
                ))
            val ranges = sfc.getRangesCoveringQuery(query).toList
            println(ranges.length)
        }

    }
    it("Number of ranges in HilbertLongHStrip"){

        println()
        var x = 10
      while(x != 20){
          val sfc = new HilbertCurve2D(x)
          val ranges = sfc.toRanges(-90, -45, 90, 45)
          println("HilbertLongHStrip"+x+": "+ranges.size)
          x += 1
      }

    }
  }
}
