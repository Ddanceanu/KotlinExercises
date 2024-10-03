package com.dungeons

import kotlin.random.Random

class Map(
    private val player: Player,
    private val nonDeterministic: Boolean = false,
) {
    private val map: Array<Array<Int>> =
        if (!nonDeterministic) {
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
        } else {
            generateRandomMap()
        }

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
        val userInput = (readlnOrNull() ?: "FRONT").uppercase()
        when (userInput) {
            "FRONT" -> {
                playerPositionRow++
                player.playFight(map[playerPositionRow][playerPositionCol])
            }
            "LEFT" -> {
                try {
                    if (playerPositionCol == 0) {
                        throw ArrayIndexOutOfBoundsException("Invalid input")
                    }
                    playerPositionCol--
                    playerPositionRow++
                    player.playFight(map[playerPositionRow][playerPositionCol])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    println("Invalid move. Please try again!")
                }
            }
            "RIGHT" -> {
                try {
                    if (playerPositionCol == 2) {
                        throw ArrayIndexOutOfBoundsException("Invalid input")
                    }
                    playerPositionCol++
                    playerPositionRow++
                    player.playFight(map[playerPositionRow][playerPositionCol])
                } catch (e: ArrayIndexOutOfBoundsException) {
                    println("Invalid move. Please try again!")
                }
            }
            "HEALTH" -> {
                if (player.health == 100 && player.healthPotions > 0) {
                    println("Your health is already 100%.\n")
                } else if (player.healthPotions > 0) {
                    player.health = 100
                    player.healthPotions--
                    println("Now you health is 100%.\n")
                } else {
                    println("You don't have any health potions.\n")
                }
            }
            "ARMOUR" -> {
                if (player.armour == 100 && player.armourPotions > 0) {
                    println("Your armour is already 100%.\n")
                } else if (player.armourPotions > 0) {
                    player.armour += 25
                    player.armourPotions--
                    if (player.armour > 100) {
                        player.armour = 100
                    }
                    println("Now your armour is ${player.armour}%.\n")
                } else {
                    println("You don't have any armour potions.\n")
                }
            }
            "exit" -> {
                player.gameStatus = false
            }
            else -> {
                println("Unknown command.\n")
            }
        }
    }

    private fun generateRandomMap(): Array<Array<Int>> {
        val rows = Random.nextInt(7, 12)
        val firstRow = arrayOf(0, 0, 0)
        val lastRow = arrayOf(4, 4, 4)
        val middleRows =
            Array(rows - 2) {
                arrayOf(generateRandomNumberWithoutTroll(), generateRandomNumberWithoutTroll(), generateRandomNumberWithoutTroll())
            }
        return arrayOf(firstRow, *middleRows, lastRow)
    }

    fun displayMap() {
        map.forEach { rows ->
            println(rows.joinToString(","))
        }
    }

    private fun generateRandomNumberWithoutTroll(): Int {
        val num = Random.nextInt(0, 2)
        return if (num == 0) {
            Random.nextInt(0, 4)
        } else {
            Random.nextInt(5, 11)
        }
    }
}
