package com.project

import java.io.File

import scala.annotation.tailrec
import scala.io.Source

object Scala7 {
  def main(args: Array[String]): Unit = {
    val replaysFolder = new File("src/com/project/replays")
    val files = replaysFolder.listFiles()
    var results = new Array[Int](10)
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
    var oldResults = new Array[Int](10)
    oldResults = results
    results = sort(results.toList).toArray
    println("MOST FREQUENT ACTIONS:")
    for (index <- 0 to results.length - 1) {
      if (oldResults(index) == results(0)) {
        index match {
          case 0 => println(case0)
          case 1 => println(case1)
          case 2 => println(case2)
          case 3 => println(case3)
          case 4 => println(case4)
          case 5 => println(case5)
          case 6 => println(case6)
          case 7 => println(case7)
          case 8 => println(case8)
          case 9 => println(case9)
          case _ =>
        }
      }
    }
  }

  def calculator(results: Array[Int]): Unit = {
    var all = 0
    for (index <- 0 to results.length - 1) {
      all += results(index)
    }
    println("PLAYER MOVED UP" + " " + results(0).toDouble * 100 / all + "%")
    println("PLAYER MOVED DOWN" + " " + results(1).toDouble * 100 / all + "%")
    println("PLAYER MOVED LEFT" + " " + results(2).toDouble * 100 / all + "%")
    println("PLAYER MOVED RIGHT" + " " + results(3).toDouble * 100 / all + "%")
    println("PLAYER SHOOTED" + " " + results(4).toDouble * 100 / all + "%")
    println("ENEMY MOVED UP" + " " + results(5).toDouble * 100 / all + "%")
    println("ENEMY MOVED DOWN" + " " + results(6).toDouble * 100 / all + "%")
    println("ENEMY MOVED LEFT" + " " + results(7).toDouble * 100 / all + "%")
    println("ENEMY MOVED RIGHT" + " " + results(8).toDouble * 100 / all + "%")
    println("ENEMY SHOOTED" + " " + results(9).toDouble * 100 / all + "%")
  }

  def sort(list: List[Int]): List[Int] = {
    @tailrec
    def helpSort(l: List[Int], reminder: List[Int]): List[Int] = {
      if (reminder.isEmpty)
        l
      else
        helpSort(reminder.filter(_ == reminder.min) ++ l, reminder.filter(_ > reminder.min)) //по убыванию
    }
    helpSort(Nil, list)
  }
}
