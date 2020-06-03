package com.project

import java.io.File

import scala.io.Source
import scala.util.matching.Regex

object Scala8 {
  def main(args: Array[String]): Unit = {
    val replaysFolder = new File("src/com/project/replays")
    val files = replaysFolder.listFiles()
    val maps = new Array[String](files.length)
    for (index <- 0 to files.length - 1) {
      maps(index) = ""
    }
    for (index <- 0 to files.length - 1) {
      for (i: String <- Source.fromFile(files(index)).getLines) {
        i match {
          case i if i.matches("MAP") =>
          case i if i.matches("PLAYER MOVED UP") =>
          case i if i.matches("PLAYER MOVED DOWN") =>
          case i if i.matches("PLAYER MOVED LEFT") =>
          case i if i.matches("PLAYER MOVED RIGHT") =>
          case i if i.matches("PLAYER SHOOTED") =>
          case i if i.matches("ENEMY MOVED UP") =>
          case i if i.matches("ENEMY MOVED DOWN") =>
          case i if i.matches("ENEMY MOVED LEFT") =>
          case i if i.matches("ENEMY MOVED RIGHT") =>
          case i if i.matches("ENEMY SHOOTED") =>
          case i if i.matches("END") => i
          case _ => maps(index) += i
            maps(index) += '\n'
        }
      }
    }
    val patternSpace: Regex = " ".r
    val patternBrick: Regex = "1".r
    val patternMetal: Regex = "2".r
    val patternGrass: Regex = "3".r
    val patternIce: Regex = "4".r
    val patternWater: Regex = "5".r
    for (index <- 0 to files.length - 1) {
      maps(index) = patternSpace.replaceAllIn(maps(index), "S ")
      maps(index) = patternBrick.replaceAllIn(maps(index), "B ")
      maps(index) = patternMetal.replaceAllIn(maps(index), "M ")
      maps(index) = patternGrass.replaceAllIn(maps(index), "G ")
      maps(index) = patternIce.replaceAllIn(maps(index), "I ")
      maps(index) = patternWater.replaceAllIn(maps(index), "W ")
    }
    for (index <- 0 to files.length - 1) {
      print(maps(index))
      println()
    }
  }
}