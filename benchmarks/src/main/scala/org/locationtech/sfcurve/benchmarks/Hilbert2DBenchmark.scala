package org.locationtech.sfcurve.benchmarks

import org.locationtech.sfcurve.hilbert._
import com.google.caliper.Param


object HilbertBenchmark extends BenchmarkRunner(classOf[HilbertBenchmark])

class HilbertBenchmark extends CurveBenchmark {


  //def timeHilbertBadCase(reps: Int) = run(reps)(HilbertBadCase)
  def HilbertBadCase = {

      var i = 2 //resolution bits
      while (i < 20){
          val sfc = new HilbertCurve2D(i)
          val range = sfc.toRanges(-178.123456, -86.398493, 179.3211113, 87.393483)
          i += 1
      }

  }

  //def timeHilbertCityCase(reps: Int) = run(reps)(HilbertCityCase)
  def HilbertCityCase = {
      var i = 10
      var lx = -180
      var ly = 89.68103
      var ux = -179.597625
      var uy = 90
      var yrun = 0
      var xrun = 0

      while (i < 24){
          val sfc = new HilbertCurve2D(i)
          while((yrun + ly) > -90){
              xrun = 0
              while ((xrun + ux) < 180){
                  val range = sfc.toRanges(lx+xrun, ly+yrun, ux+xrun, uy+yrun)
                  xrun += 5
              }
              yrun -= 5
          }
          i += 1
      }
  }

  //def timeHilbertStateCase(reps: Int) = run(reps)(HilbertStateCase)
  def HilbertStateCase = {
      var i = 6
      var lx = -180
      var ly = 86.022914
      var ux = -173.078613
      var uy = 90
      var yrun = 0
      var xrun = 0

      while (i < 24){
          val sfc = new HilbertCurve2D(i)
          while ((yrun + ly) > -90){
              xrun = 0
              while((xrun + ux) < 180){
                  val range = sfc.toRanges(lx+xrun, ly+yrun, ux+xrun, uy+yrun)
                  xrun += 5
              }
              yrun -= 5
          }

          i += 1
      }
  }

  //def timeHilbertCountryCase(reps: Int) = run(reps)(HilbertCountryCase)
  def HilbertCountryCase = {
      var i = 6
      var lx = -180
      var ly = 82.689749
      var ux = -171.408692
      var uy = 90
      var yrun = 0
      var xrun = 0

      while (i < 24){
          val sfc = new HilbertCurve2D(i)
          while ((yrun + ly) > -90){
              xrun = 0
              while((xrun + ux) < 180){
                  val range = sfc.toRanges(lx+xrun, ly+yrun, ux+xrun, uy+yrun)
                  xrun += 5
              }
              yrun -= 5
          }

          i += 1
      }
  }
  //def timeHilbertResolution5(reps: Int) = run(reps)(HilbertResolution(5))
  //def timeHilbertResolution6(reps: Int) = run(reps)(HilbertResolution(6))
  //def timeHilbertResolution7(reps: Int) = run(reps)(HilbertResolution(7))
  //def timeHilbertResolution8(reps: Int) = run(reps)(HilbertResolution(8))
  //def timeHilbertResolution9(reps: Int) = run(reps)(HilbertResolution(9))
  def timeHilbertResolution10(reps: Int) = run(reps)(HilbertResolution(10))
  def timeHilbertResolution11(reps: Int) = run(reps)(HilbertResolution(11))
  def timeHilbertResolution12(reps: Int) = run(reps)(HilbertResolution(12))
  def timeHilbertResolution13(reps: Int) = run(reps)(HilbertResolution(13))
  def timeHilbertResolution14(reps: Int) = run(reps)(HilbertResolution(14))
  def timeHilbertResolution15(reps: Int) = run(reps)(HilbertResolution(15))
  def timeHilbertResolution16(reps: Int) = run(reps)(HilbertResolution(16))
  def timeHilbertResolution17(reps: Int) = run(reps)(HilbertResolution(17))
  def timeHilbertResolution18(reps: Int) = run(reps)(HilbertResolution(18))
  def timeHilbertResolution19(reps: Int) = run(reps)(HilbertResolution(19))
  //def timeHilbertResolution20(reps: Int) = run(reps)(HilbertResolution(20))
  def HilbertResolution(i: Int) = {
      var lx = -180
      var ly = 89.68103
      var ux = -179.597625
      var uy = 90
      var yrun = 0
      var xrun = 0
      var numRanges = 0
      var count = 0

      val sfc = new HilbertCurve2D(i)
      while((yrun + ly) > -90){
          xrun = 0
          while ((xrun + ux) < 180){
              val range = sfc.toRanges(lx+xrun, ly+yrun, ux+xrun, uy+yrun)
              xrun += 5
          }
          yrun -= 5
      }
  }

  def timeHilbertMediumResolution10(reps: Int) = run(reps)(HilbertMediumResolution(10))
  def timeHilbertMediumResolution11(reps: Int) = run(reps)(HilbertMediumResolution(11))
  def timeHilbertMediumResolution12(reps: Int) = run(reps)(HilbertMediumResolution(12))
  def timeHilbertMediumResolution13(reps: Int) = run(reps)(HilbertMediumResolution(13))
  def timeHilbertMediumResolution14(reps: Int) = run(reps)(HilbertMediumResolution(14))
  //def timeHilbertMediumResolution15(reps: Int) = run(reps)(HilbertMediumResolution(15))
  //def timeHilbertMediumResolution16(reps: Int) = run(reps)(HilbertMediumResolution(16))
  //def timeHilbertMediumResolution17(reps: Int) = run(reps)(HilbertMediumResolution(17))
  //def timeHilbertMediumResolution18(reps: Int) = run(reps)(HilbertMediumResolution(18))
  //def timeHilbertMediumResolution19(reps: Int) = run(reps)(HilbertMediumResolution(19))
  def HilbertMediumResolution(i: Int) = {
      var lx = -180
      //var ly = 89.0
      var ly = 82.689749
      var ux = -171.408692
      //var ly = 87.0
      //var ux = 175.0
      //var ly = 88.0
      //var ux = -178.2
      //var ux = -178.9
      var uy = 90
      var yrun = 0
      var xrun = 0
      var numRanges = 0
      var count = 0

      val sfc = new HilbertCurve2D(i)
      while((yrun + ly) > -90){
          xrun = 0
          while ((xrun + ux) < 180){
              val range = sfc.toRanges(lx+xrun, ly+yrun, ux+xrun, uy+yrun)
              xrun += 5
          }
          yrun -= 5
      }
  }

  def timeHilbertHalfBoundary10(reps: Int) = run(reps)(HilbertHalfBoundary(10))
  def timeHilbertHalfBoundary11(reps: Int) = run(reps)(HilbertHalfBoundary(11))
  def timeHilbertHalfBoundary12(reps: Int) = run(reps)(HilbertHalfBoundary(12))
  def timeHilbertHalfBoundary13(reps: Int) = run(reps)(HilbertHalfBoundary(13))
  def timeHilbertHalfBoundary14(reps: Int) = run(reps)(HilbertHalfBoundary(14))
  def timeHilbertHalfBoundary15(reps: Int) = run(reps)(HilbertHalfBoundary(15))
  def timeHilbertHalfBoundary16(reps: Int) = run(reps)(HilbertHalfBoundary(16))
  def timeHilbertHalfBoundary17(reps: Int) = run(reps)(HilbertHalfBoundary(17))
  def timeHilbertHalfBoundary18(reps: Int) = run(reps)(HilbertHalfBoundary(18))
  def HilbertHalfBoundary(i: Int) = {
      var lx = -90
      var ly = -45
      var ux = 90
      var uy = 45
      var yrun = 0
      var xrun = 0
      var numRanges = 0
      var count = 0

      val sfc = new HilbertCurve2D(i)
      sfc.toRanges(lx, ly, ux, uy)
  }

  def timeHilbertLongHStrip10(reps: Int) = run(reps)(HilbertLongHStrip(10))
  def timeHilbertLongHStrip11(reps: Int) = run(reps)(HilbertLongHStrip(11))
  def timeHilbertLongHStrip12(reps: Int) = run(reps)(HilbertLongHStrip(12))
  def timeHilbertLongHStrip13(reps: Int) = run(reps)(HilbertLongHStrip(13))
  def timeHilbertLongHStrip14(reps: Int) = run(reps)(HilbertLongHStrip(14))
  def timeHilbertLongHStrip15(reps: Int) = run(reps)(HilbertLongHStrip(15))
  def timeHilbertLongHStrip16(reps: Int) = run(reps)(HilbertLongHStrip(16))
  def timeHilbertLongHStrip17(reps: Int) = run(reps)(HilbertLongHStrip(17))
  def timeHilbertLongHStrip18(reps: Int) = run(reps)(HilbertLongHStrip(18))
  def timeHilbertLongHStrip19(reps: Int) = run(reps)(HilbertLongHStrip(19))
  def timeHilbertLongHStrip20(reps: Int) = run(reps)(HilbertLongHStrip(20))
  def HilbertLongHStrip(i: Int) = {
      var offset = 40
      var lx = -120
      var ly = -20
      var ux = 120
      var uy = 20
      var yrun = 0
      var xrun = 0
      var numRanges = 0
      var count = 0

      val sfc = new HilbertCurve2D(i)
      sfc.toRanges(lx, ly-offset, ux, uy-offset)
  }

  def timeHilbertQuadrant10(reps: Int) = run(reps)(HilbertQuadrant(10))
  def timeHilbertQuadrant11(reps: Int) = run(reps)(HilbertQuadrant(11))
  def timeHilbertQuadrant12(reps: Int) = run(reps)(HilbertQuadrant(12))
  def timeHilbertQuadrant13(reps: Int) = run(reps)(HilbertQuadrant(13))
  def timeHilbertQuadrant14(reps: Int) = run(reps)(HilbertQuadrant(14))
  def timeHilbertQuadrant15(reps: Int) = run(reps)(HilbertQuadrant(15))
  def timeHilbertQuadrant16(reps: Int) = run(reps)(HilbertQuadrant(16))
  def timeHilbertQuadrant17(reps: Int) = run(reps)(HilbertQuadrant(17))
  def timeHilbertQuadrant18(reps: Int) = run(reps)(HilbertQuadrant(18))
  def timeHilbertQuadrant19(reps: Int) = run(reps)(HilbertQuadrant(19))
  def timeHilbertQuadrant20(reps: Int) = run(reps)(HilbertQuadrant(20))
  def HilbertQuadrant(i: Int) = {
      var lx = 0
      var ly = 0
      var ux = 180
      var uy = 90
      var yrun = 0
      var xrun = 0
      var numRanges = 0
      var count = 0

      val sfc = new HilbertCurve2D(i)
      sfc.toRanges(lx, ly, ux, uy)
  }


}
