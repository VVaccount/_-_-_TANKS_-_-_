package com.project

import java.io.File
import java.util.regex.{Matcher, Pattern}
import scala.util.control.Breaks._
import scala.annotation.tailrec
import scala.io.Source

object Scala {
  def main(args: Array[String]): Unit = {
    val replaysFolder = new File("src/com/project/replays")
    val files = replaysFolder.listFiles()
    val results = new Array[Int](files.length)
    val stringResults = new Array[String](files.length)
    var file = ""
    for (index <- 0 to files.length - 1) {
      file = "src/com/project/replays/" + files(index).getName
      for (line <- Source.fromFile(file).getLines) {
        results(index) += 1
      }
      stringResults(index) = results(index) + " " + "src/com/project/replays/" + files(index).getName
      println(stringResults(index))
    }
    println()
    for (x <- sort(results)) {
      var pattern = Pattern.compile(x.toString)
      breakable {
        for (index1 <- 0 to files.length - 1) {
          for (index <- 0 to files.length - 1) {
            var matcher = pattern.matcher(stringResults(index))
            if (matcher.find()) {
              var memory = stringResults(index1)
              stringResults(index1) = stringResults(index)
              stringResults(index) = memory
              break
            }
          }
        }
      }
    }
    for (index <- 0 to files.length - 1) {
      println(stringResults(index));
    }
  }

  def sort(list: List[Int]): List[Int] = {
    @tailrec
    def helpSort(l: List[Int], reminder: List[Int]): List[Int] = {
      if (reminder.isEmpty)
        l
      else
        helpSort(reminder.filter(_ == reminder.max) ++ l, reminder.filter(_ < reminder.max)) //по возрастанию
        //helpSort(reminder.filter(_ == reminder.min) ++ l, reminder.filter(_ > reminder.min)) //по убыванию
    }

    helpSort(Nil, list)
  }

  def sort(a: Array[Int]): Array[Int] = {
    val b: Array[Int] = new Array[Int](a.length)
    Array.copy(a, 0, b, 0, a.length)
    // Function to swap elements
    def exchange(i: Int, j: Int): Unit = {
      val k = b(i)
      b(i) = b(j)
      b(j) = k
    }
    @tailrec
    def helper(b: Array[Int], i: Int): Array[Int] = {
      if (i == b.length - 1) return b
      else {
        val head = b(i)
//        val maximumInTail = b.slice(i, b.length).max
//        //по убыванию
//        if (head < maximumInTail) {
//          val maximumInTailIndex = b.slice(i, b.length).indexOf(maximumInTail);
//          exchange(i, maximumInTailIndex + i)
//        }
        //по возрастанию
        val minimumInTail = b.slice(i, b.length).min
        if (head > minimumInTail) {
          val minimumInTailIndex = b.slice(i, b.length).indexOf(minimumInTail)
          exchange(i, minimumInTailIndex + i)
        }
        helper(b, i + 1)
      }
    }
    helper(b, 0)
  }
}