package org.locationtech.sfcurve.benchmarks

import org.locationtech.sfcurve.hilbert._
import com.google.caliper.Param
//import sfseize._
import org.eichelberger.sfc.CompactHilbertCurve
import org.eichelberger.sfc.CompactHilbertCurve._
import org.eichelberger.sfc.SpaceFillingCurve._


object SFSeizeHilbertBenchmark extends BenchmarkRunner(classOf[SFSeizeHilbertBenchmark])

class SFSeizeHilbertBenchmark extends CurveBenchmark {

    def timeHilbertSmallResolution10(reps: Int) = run(reps)(HilbertSmallResolution(10))
    def HilbertSmallResolution(i:Int) = {
        val precision = math.pow(2, i)
        val sfc = CompactHilbertCurve(OrdinalVector(i, i))
          val query = Query(Seq(
            OrdinalRanges(OrdinalPair(i/4, i/4)),
            OrdinalRanges(OrdinalPair(i*3/4, i*3/4))
          ))
          val ranges = sfc.getRangesCoveringQuery(query).toList
    }

    def timeHilbertHalfBoundary10(reps: Int) = run(reps)(HilbertHalfBoundary(10))
    def HilbertHalfBoundary(i:Int) = {
        val precision = math.pow(2, i)
        val sfc = CompactHilbertCurve(OrdinalVector(i, i))
        val query = Query(Seq(
            OrdinalRanges(OrdinalPair(i/4, i/4)),
            OrdinalRanges(OrdinalPair(i*3/4, i*3/4))
            ))
        val ranges = sfc.getRangesCoveringQuery(query).toList
  }

  def timeHilbertQuadrant10(reps: Int) = run(reps)(HilbertQuadrant(10))
  def HilbertQuadrant(i:Int) = {
      val precision = math.pow(2, i)
      val sfc = CompactHilbertCurve(OrdinalVector(i,i))
      val query = Query(Seq(
          OrdinalRanges(OrdinalPair(0, 0)),
          OrdinalRanges(OrdinalPair(i/2, i/2))
      ))
      val ranges = sfc.getRangesCoveringQuery(query).toList
  }

  /*def timeHilbertLongHStrip10(reps: Int) = run(reps)(HilbertLongHStrip(10))
  def HilbertLongHStrip(i:Int) = {
      val precision = math.pow(2, i)
      val sfc = CompactHilbertCurve(OrdinalVector(i,i))
      val query = Query(Seq(
          OrdinalRanges(OrdinalPair(0,i/5)),
          OrdinalRanges(OrdinalPair(i,0))
      ))
      val ranges = sfc.getRangesCoveringQuery(query).toList
  }*/
}
