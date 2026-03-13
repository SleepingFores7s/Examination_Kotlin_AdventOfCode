fun main() {

//    val value = listOf("Hanna", "Johanna", "Lisa")
//
//    println(value[1]) //Johanna
//    println(value[0]) //Hanna
//    println(value[2]) //Lisa
//
//    val name:String = "Erika"
//    println(name[4]) // k
//    println(name[1]) // r

    floorModShow()
}

fun floorModShow() {

    var moveAmount:Int = 50
    println("Move 50: " + Math.floorMod(moveAmount, 100)) //50 (0 + 50)

    moveAmount = 150
    println("Move 150: " + Math.floorMod(moveAmount, 100)) //50 (0 + 150)

    moveAmount = 125
    println("Move 125: " + Math.floorMod(moveAmount, 100)) //125 (0 + 125)

    var startLocation:Int = 50
    moveAmount = 50
    println("Start 50, Move 50: " + Math.floorMod(startLocation + moveAmount, 100)) //100 (50 + 50)

    startLocation = 25
    moveAmount = 50
    println("Start 25, Move 50: " + Math.floorMod(startLocation + moveAmount, 100)) //75 (25 + 50)

    startLocation = 50
    moveAmount = 300
    println("Start 50, Move 300: " + Math.floorMod(startLocation + moveAmount, 100)) //50 (50 + 300)
}