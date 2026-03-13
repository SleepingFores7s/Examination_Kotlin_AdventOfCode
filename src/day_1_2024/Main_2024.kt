package day_1_2024

import java.io.File

/*
Advent of Code - 2024 Day 1

A: Pair lowest digit from each list, then second lowest, and on and on, then sum everything together.
B: For each number in left list, check how many times that digit appears and multiply left number by result.
*/

fun main() {

    val bigData = readFileData()

    val collectedData: MutableList<Pair<Int, Int>> = mutableListOf()

    val brokenUpData1: MutableList<Int> = mutableListOf()
    val brokenUpData2: MutableList<Int> = mutableListOf()


    //todo Task A --------------------------------------------------------
    for (data in bigData) {
        collectedData.add(convertListToInts(data))
    }

    for (values in collectedData) {
        brokenUpData1.add(values.first)
        brokenUpData2.add(values.second)
    }

    brokenUpData1.sort()
    brokenUpData2.sort()

    var sumOfData: Long = 0
    var i = 0
    while (i < brokenUpData1.size) {
        sumOfData += evaluateDistanceBetweenPairs(brokenUpData1[i], brokenUpData2[i])
        i++
    }

    println("Task A sum: $sumOfData")


    //todo Task B --------------------------------------------------------
    sumOfData = 0
    for (singleData in brokenUpData1) {
        sumOfData += similarityScoreEvaluation(singleData, brokenUpData2)
    }

    println("Task B sum: $sumOfData")

}

fun readFileData(): List<String> {
    return File("src/day_1_2024/inputData.txt").readLines()
}

fun convertListToInts(data: String): Pair<Int, Int> {

    val dataSplitted = data.split(" ").filter { it.isNotBlank() }

    val number1: Int = dataSplitted[0].toInt()
    val number2: Int = dataSplitted[1].toInt()

    return Pair(number1, number2)

}

fun evaluateDistanceBetweenPairs(data1: Int, data2: Int): Int {

    if (data1 >= data2) {
        return (data1 - data2)
    } else {
        return (data2 - data1)
    }

}

//todo Task B --------------------------------------------------------
fun similarityScoreEvaluation(singleData: Int, manyData: List<Int>): Long {

    var amountOfMatches: Int = 0

    for (data in manyData) {
        if (singleData == data) {
            amountOfMatches++
        }
    }
    return (singleData * amountOfMatches).toLong()
}