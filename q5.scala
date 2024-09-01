object LetterOccurences extends App{
    def countLetterOccurences(words:List[String]) : Int = {
        val lengths = words.map(_.length)
        lengths.reduce(_+_)
    }

    val words = List("apple","banana","cherry","date")

    val totalOccurences = countLetterOccurences(words)

    println(s"Total count of letter occurences : $totalOccurences")
}