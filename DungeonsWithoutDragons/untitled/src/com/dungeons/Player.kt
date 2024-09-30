package com.dungeons

class Player(
    val name: String?,
) {
    var health: Int = 100
    var armour: Int = 0

    fun displayStatus() {
        println("Player: $name has:\n Health: $health\n Armour: $armour\n")
    }

    fun playFight(event: Int) {
        println("Event: $event")
        when (event) {
            0 -> {
                println("You are in an empty room.")
            }
            1 -> {
                println("This room is guarded by a skeleton. Prepare for battle!")
                Thread.sleep(1000)
            }
            else -> {
                println("Alt caz")
            }
        }
    }
}
