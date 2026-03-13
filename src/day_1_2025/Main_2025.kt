package day_1_2025

import java.io.File

/*
Advent of Code - 2024 Day 1

A: Check how many times currentLocation stops at zero
B: Check how many times currentLocation points/passes zero
*/

fun main() {

    val startLocation: Int = 50
    var movingDirection: Char
    var movingAmount: Int

    val bigData: List<String> = readFileData()

    val smallData: MutableList<Pair<Char, Int>> = mutableListOf()

    //todo Task A --------------------------------------------------------
    for (data in bigData) {
        smallData.add(combinationTurn(data))
    }

    var currentLocation = startLocation
    var passwordCount: Int = 0
    for (data in smallData) {

        //Sets Direction & Amount
        movingDirection = data.first
        movingAmount = data.second

        currentLocation = calculateCurrentLocation(
            currentLocation,
            movingDirection,
            movingAmount
        )

        if (currentLocation == 0) {
            passwordCount++
        }
    }
    println("Task A password: $passwordCount")

    //todo Task B --------------------------------------------------------
    currentLocation = startLocation
    passwordCount = 0
    for (data in smallData) {

        movingDirection = data.first
        movingAmount = data.second

        val movementStep = if (movingDirection == 'L') -1 else 1

        repeat(movingAmount) {

            currentLocation = Math.floorMod(currentLocation + movementStep, 100)

            if (currentLocation == 0) {
                passwordCount++
            }
        }
    }

    println("Task B password: $passwordCount")

}

fun readFileData(): List<String> {
    return File("src/day_1_2025/inputData.txt").readLines()
}

fun combinationTurn(stringToSplit: String): Pair<Char, Int> {

    val splitStringDirection = stringToSplit[0]
    val splitStringAmount = stringToSplit.substring(1).toInt()

    return Pair(splitStringDirection, splitStringAmount)
}

fun calculateCurrentLocation(currentLocation: Int, moveDirection: Char, moveAmount: Int): Int {

    val movement = if (moveDirection == 'L') {
        -moveAmount
    } else {
        moveAmount
    }

    //floorMod Always starts at 0
    return Math.floorMod(currentLocation + movement, 100)

}