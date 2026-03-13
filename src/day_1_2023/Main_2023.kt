package day_1_2023

import java.io.File

/*
Advent of Code - 2023 Day 1

A: Grab first & last digit, put them together, then add every numbe together
B: Grab first & last digit/word, put them together, then add every numbe together
*/

fun main() {

    val bigData: List<String> = readFileData()

    //todo Task A --------------------------------------------------------
    var sumOfAll_A:Int = 0

    for (data in bigData) {
        sumOfAll_A += filterOutNumber(data)
    }
    println("Sum of task A numbers: $sumOfAll_A")

    //todo Task B --------------------------------------------------------
    var sumOfAll_B: Int = 0

    for (data in bigData) {
        sumOfAll_B += filterOutTextNumber(data)
    }
    println("Sum of task B numbers: $sumOfAll_B")

}

fun readFileData(): List<String> {
    return File("src/day_1_2023/inputData.txt").readLines()
}

//todo Task A --------------------------------------------------------
fun filterOutNumber(stringToFilter: String): Int {

    var firstValue = 0
    var secondValue = 0

    var i = 0
    while (i < stringToFilter.length) {

        if (stringToFilter[i].isDigit()) {
            firstValue = stringToFilter[i].digitToInt()
            break
        }
        i++
    }

    i = stringToFilter.length - 1
    while (i >= 0) {

        if (stringToFilter[i].isDigit()) {
            secondValue = stringToFilter[i].digitToInt()
            break
        }
        i--
    }
    return (firstValue * 10 + secondValue)
}

//todo Task B --------------------------------------------------------
fun filterOutTextNumber(stringToFilter: String): Int {

    var firstValue = 0
    var secondValue = 0

    //Find first
    for (i in stringToFilter.indices) {

        //Number
        if (stringToFilter[i].isDigit()) {
            firstValue = stringToFilter[i].digitToInt()
            break
        }

        //Word
        for (word in Numbers.entries) {
            if (stringToFilter.startsWith(word.wordNumber, i, true)) {
                firstValue = word.numberValue
                break
            }
        }
        if (firstValue != 0) break
    }

    //Find Last
    for (i in stringToFilter.indices.reversed()) {

        //Number
        if (stringToFilter[i].isDigit()) {
            secondValue = stringToFilter[i].digitToInt()
            break
        }

        //Word
        for (word in Numbers.entries) {
            if (stringToFilter.startsWith(word.wordNumber, i, true)) {
                secondValue = word.numberValue
                break
            }
        }
        if (secondValue != 0) break
    }
    return (firstValue * 10 + secondValue)
}

enum class Numbers(val wordNumber: String, val numberValue: Int) {
    ONE("ONE", 1),
    TWO("TWO", 2),
    THREE("THREE", 3),
    FOUR("FOUR", 4),
    FIVE("FIVE", 5),
    SIX("SIX", 6),
    SEVEN("SEVEN", 7),
    EIGHT("EIGHT", 8),
    NINE("NINE", 9)
}