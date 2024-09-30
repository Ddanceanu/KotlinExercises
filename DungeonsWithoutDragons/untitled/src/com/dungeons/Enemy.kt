package com.dungeons

abstract class Enemy {
    abstract var health: Int
    abstract var damage: Int

    fun receiveDamage(receivedDamage: Int) {
        this.health -= receivedDamage
    }
}

class Skeleton : Enemy() {
    override var health: Int = 30
    override var damage: Int = 5
}

class Goblin : Enemy() {
    override var health: Int = 50
    override var damage: Int = 10
}

class Orc : Enemy() {
    override var health: Int = 75
    override var damage: Int = 20
}

class Troll : Enemy() {
    override var health: Int = 125
    override var damage: Int = 30
}
