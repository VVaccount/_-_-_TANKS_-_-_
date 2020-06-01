package com.project

import java.io.File
import scala.io.Source

object Scala7 {
  def main(args: Array[String]): Unit = {
    val replaysFolder = new File("src/com/project/replays")
    val files = replaysFolder.listFiles()
    val results = new Array[Int](10)
    val case0 = "PLAYER MOVED UP"
    val case1 = "PLAYER MOVED DOWN"
    val case2 = "PLAYER MOVED LEFT"
    val case3 = "PLAYER MOVED RIGHT"
    val case4 = "PLAYER SHOOTED"
    val case5 = "ENEMY MOVED UP"
    val case6 = "ENEMY MOVED DOWN"
    val case7 = "ENEMY MOVED LEFT"
    val case8 = "ENEMY MOVED RIGHT"
    val case9 = "ENEMY SHOOTED"
    for (index <- 0 to files.length - 1) {
      for (i: String <- Source.fromFile(files(index)).getLines) {
        i match {
          case i if case0.matches(i) => results(0) += 1
          case i if case1.matches(i) => results(1) += 1
          case i if case2.matches(i) => results(2) += 1
          case i if case3.matches(i) => results(3) += 1
          case i if case4.matches(i) => results(4) += 1
          case i if case5.matches(i) => results(5) += 1
          case i if case6.matches(i) => results(6) += 1
          case i if case7.matches(i) => results(7) += 1
          case i if case8.matches(i) => results(8) += 1
          case i if case9.matches(i) => results(9) += 1
          case _ =>
        }
      }
    }
    calculator(results)
  }

  def calculator(results: Array[Int]): Unit ={
    var all = 0
    for (index <- 0 to results.length - 1) {
      all += results(index)
    }
    println("PLAYER MOVED UP" + " " + results(0) * 100 / all + "%")
    println("PLAYER MOVED DOWN" + " " + results(1) * 100 / all + "%")
    println("PLAYER MOVED LEFT" + " " + results(2) * 100 / all + "%")
    println("PLAYER MOVED RIGHT" + " " + results(3) * 100 / all + "%")
    println("PLAYER SHOOTED" + " " + results(4) * 100 / all + "%")
    println("ENEMY MOVED UP" + " " + results(5) * 100 / all + "%")
    println("ENEMY MOVED DOWN" + " " + results(6) * 100 / all + "%")
    println("ENEMY MOVED LEFT" + " " + results(7) * 100 / all + "%")
    println("ENEMY MOVED RIGHT" + " " + results(8) * 100 / all + "%")
    println("ENEMY SHOOTED" + " " + results(9) * 100 / all + "%")
  }
}
