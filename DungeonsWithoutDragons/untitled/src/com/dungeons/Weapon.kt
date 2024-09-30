package com.dungeons

enum class Weapons(
    val damage: Int,
) {
    FIST(5),
    PISTOL(10),
    RIFLE(20),
    MACHINE_GUN(30),
}

class Weapon {
    val currentWeapon = Weapons.FIST
}
