package com.dungeons

class Map(
    val player: Player,
    val rows: Int = 3,
    val cols: Int = 3,
) {
    val map: Array<Array<Int>> =
        arrayOf(
            arrayOf(0, 0, 0),
            arrayOf(1, 1, 6),
            arrayOf(3, 8, 8),
        )

    var playerPositionRow = 0
    var playerPositionCol = 1

    fun displayNextMove() {
        when (playerPositionCol) {
            0 -> {
                println("You have two doors ahead. Do you want to enter the one in front of you, or the one on your right?")
                println("Type: FRONT/RIGHT")
            }
            1 -> {
                println(
                    "You have three doors ahead. Do you want to enter the one in front of you, the one on your left or the one on your right?",
                )
                println("Type: FRONT/LEFT/RIGHT")
            }
            2 -> {
                println("You have two doors ahead. Do you want to enter the one in front of you, the one on your left?")
                println("Type: FRONT/LEFT")
            }
        }
    }

    fun readNextMove() {
        var userInput = (readLine() ?: "FRONT").uppercase()
        println("Ai tastat: $userInput")
        when (userInput) {
            "FRONT" -> {
                playerPositionRow++
                player.playFight(map[playerPositionRow][playerPositionCol])
            }
        }
    }
}
