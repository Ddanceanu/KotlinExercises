package com.dungeons

class Map(
    private val player: Player,
) {
    private val map: Array<Array<Int>> =
        arrayOf(
            arrayOf(0, 0, 0),
            arrayOf(8, 5, 6),
            arrayOf(3, 0, 1),
            arrayOf(0, 2, 6),
            arrayOf(6, 5, 0),
            arrayOf(0, 8, 6),
            arrayOf(0, 2, 5),
            arrayOf(3, 10, 5),
            arrayOf(4, 4, 4),
        )

    private var playerPositionRow = 0
    private var playerPositionCol = 1

    fun displayNextMove() {
        when (playerPositionCol) {
            0 -> {
                println("You have two doors ahead. Do you want to enter the one in front of you, or the one on your right?")
                println("Type: FRONT/RIGHT or health | armour")
            }
            1 -> {
                println(
                    "You have three doors ahead. Do you want to enter the one in front of you, the one on your left or the one on your right?",
                )
                println("Type: FRONT/LEFT/RIGHT or health | armour")
            }
            2 -> {
                println("You have two doors ahead. Do you want to enter the one in front of you, the one on your left?")
                println("Type: FRONT/LEFT or health | armour")
            }
        }
    }

    fun readNextMove() {
        val userInput = (readLine() ?: "FRONT").uppercase()
        when (userInput) {
            "FRONT" -> {
                playerPositionRow++
                player.playFight(map[playerPositionRow][playerPositionCol])
            }
            "LEFT" -> {
                playerPositionCol--
                playerPositionRow++
                player.playFight(map[playerPositionRow][playerPositionCol])
            }
            "RIGHT" -> {
                playerPositionCol++
                playerPositionRow++
                player.playFight(map[playerPositionRow][playerPositionCol])
            }
            "HEALTH" -> {
                if (player.healthPotions > 0) {
                    player.health = 100
                    player.healthPotions--
                    println("Now you health is 100%.")
                } else {
                    println("You don't have any health potions.")
                }
            }
            "ARMOUR" -> {
                if (player.armourPotions > 0) {
                    player.armour += 25
                    player.armourPotions--
                    println("Now your armour is ${player.armour}")
                } else {
                    println("You don't have any armour potions.")
                }
            }
            "exit" -> {
                player.gameStatus = false
            }
            else -> {
                println("Unknown command.")
            }
        }
    }
}
