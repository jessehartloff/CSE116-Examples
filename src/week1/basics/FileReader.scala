package week1.basics

import scala.io.{BufferedSource, Source}

object FileReader {

  def convertFileToString(filename: String): String = {
    var contents: String = ""
    val file: BufferedSource = Source.fromFile(filename)
    for (line <- file.getLines()) {
      contents += line + "\n"
    }
    contents
  }

  def main(args: Array[String]): Unit = {
    val filename = "data/testFile.txt"
    val contents = convertFileToString(filename)
    println(contents)
  }

}
