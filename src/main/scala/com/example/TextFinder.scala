package com.example

object TextFinder {

  def main(args: Array[String]): Unit = {
    val word = "Java"

    println(isWordInText("The Java language", word))
    println(isWordInText("The JavaScript language", word))
  }

  def isWordInText(text: String, word: String): Boolean = text matches s".*\\b$word\\b.*"
}
