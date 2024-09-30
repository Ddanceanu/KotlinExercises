package com.dungeons

class Player(
    private val name: String?,
) {
    var health: Int = 100
    var armour: Int = 0
    var weapon = Weapon(Weapons.FIST)
    var gameStatus = true
    var healthPotions = 0
    var armourPotions = 0

    fun displayStatus() {
        println("Player: $name has:\n Health: $health\n Armour: $armour\n")
    }

    fun playFight(event: Int) {
        // println("Event: $event")
        when (event) {
            0 -> {
                println("You are in an empty room.")
            }
            1 -> {
                println("This room is guarded by a skeleton. Prepare for battle!")
                val skeleton = Skeleton()
                Thread.sleep(2000)
                while (health > 0 && skeleton.health > 0) {
                    println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                    println("Skeleton health: ${skeleton.health}")
                    if (armour > 0) {
                        armour -= skeleton.damage
                    } else {
                        health -= skeleton.damage
                    }
                    skeleton.health -= weapon.weaponDamage()
                    if (health < 0)health = 0
                    if (armour < 0)armour = 0
                    if (skeleton.health < 0)skeleton.health = 0
                    Thread.sleep(1000)
                }
                println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                println("Skeleton health: ${skeleton.health}")
                if (health <= 0) {
                    gameStatus = false
                    println("You have been killed by the skeleton. Good luck next time!")
                } else {
                    println("Congratulations! You killed the skeleton. Now you can move forward!\n")
                }
            }
            2 -> {
                println("This room is guarded by a goblin. Prepare for battle!")
                val goblin = Goblin()
                Thread.sleep(2000)
                while (health > 0 && goblin.health > 0) {
                    println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                    println("Goblin health: ${goblin.health}")
                    if (armour > 0) {
                        armour -= goblin.damage
                    } else {
                        health -= goblin.damage
                    }
                    goblin.health -= weapon.weaponDamage()
                    if (health < 0)health = 0
                    if (armour < 0)armour = 0
                    if (goblin.health < 0)goblin.health = 0
                    Thread.sleep(1000)
                }
                println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                println("Goblin health: ${goblin.health}")
                if (health <= 0) {
                    gameStatus = false
                    println("You have been killed by the goblin. Good luck next time!")
                } else {
                    println("Congratulations! You killed the goblin. Now you can move forward!\n")
                }
            }
            3 -> {
                println("This room is guarded by an orc. Prepare for battle!")
                val orc = Orc()
                Thread.sleep(2000)
                while (health > 0 && orc.health > 0) {
                    println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                    println("Orc health: ${orc.health}")
                    if (armour > 0) {
                        armour -= orc.damage
                    } else {
                        health -= orc.damage
                    }
                    orc.health -= weapon.weaponDamage()
                    if (health < 0)health = 0
                    if (armour < 0)armour = 0
                    if (orc.health < 0)orc.health = 0
                    Thread.sleep(1000)
                }
                println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                println("Orc health: ${orc.health}")
                if (health <= 0) {
                    gameStatus = false
                    println("You have been killed by the orc. Good luck next time!")
                } else {
                    println("Congratulations! You killed the orc. Now you can move forward!\n")
                }
            }
            4 -> {
                println("This room is guarded by a troll. Prepare for battle!")
                val troll = Troll()
                Thread.sleep(2000)
                while (health > 0 && troll.health > 0) {
                    println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                    println("Troll health: ${troll.health}")
                    if (armour > 0) {
                        armour -= troll.damage
                    } else {
                        health -= troll.damage
                    }
                    troll.health -= weapon.weaponDamage()
                    if (health < 0)health = 0
                    if (armour < 0)armour = 0
                    if (troll.health < 0)troll.health = 0
                    Thread.sleep(1000)
                }
                println("Player health: $health, armour: $armour, your weapon: ${weapon.getWeaponName()}")
                println("Troll health: ${troll.health}")
                if (health <= 0) {
                    gameStatus = false
                    println("You have been killed by the troll. Good luck next time!")
                } else {
                    println("CONGRATULATIONS! You killed the troll. YOU ARE THE WINNER!\n")
                    gameStatus = false
                }
            }
            5 -> {
                println(
                    "You found a potion that fully restores your health to 100%. It has been added to your inventory." +
                        " To use it, type health before selecting a new door.",
                )
                healthPotions++
            }
            6 -> {
                println(
                    "You found a potion that adds 25% to your armor. It has been added to your inventory." +
                        " To use it, type health before selecting a new door.",
                )
                armourPotions++
            }
            8 -> {
                println("You found a pistol. Now this is your weapon.")
                weapon.getPistol()
            }
            9 -> {
                println("You found a rifle. Now this is your weapon.")
                weapon.getRifle()
            }
            10 -> {
                println("You found a machine_gun. Now this is your weapon.")
                weapon.getMachineGun()
            }
        }
    }
}
