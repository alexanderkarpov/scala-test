package com.example

object TextFinder {

  def main(args: Array[String]): Unit = {
    val word = "C#"

    println(isWordInText("The C# language", word))
    println(isWordInText("The JavaScript language", word))

    text.split("[\\s,\\.;:]").foreach(println)
  }

  def isWordInText(text: String, word: String): Boolean = text matches s".*\\b$word\\b.*"

  val text = "Lorem C#: is simply dummy; text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
}
