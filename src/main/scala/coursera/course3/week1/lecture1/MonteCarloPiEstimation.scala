package coursera.course3.week1.lecture1

import scala.util.Random

/**
  * Created by alexander on 11/3/16.
  */
class MonteCarloPiEstimation {

  def mcCount(iter: Int): Int = {
    val randomX = new Random
    val randomY = new Random
    var hits = 0
    for (i <- 0 until iter) {
      val x = randomX.nextDouble // in [0, 1]
      val y = randomY.nextDouble // in [0, 1]
      if(x*x + y*y < 1) hits = hits + 1
    }
    hits
  }

  def monteCarloPiSeq(iter: Int): Double = 4.0 * mcCount(iter) / iter

}
