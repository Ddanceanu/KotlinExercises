package com.dungeons

enum class Weapons(
    val damage: Int,
) {
    FIST(5),
    PISTOL(10),
    RIFLE(20),
    MACHINE_GUN(30),
}

class Weapon(
    var currentWeapon: Weapons,
) {
    fun weaponDamage() = currentWeapon.damage

    fun getWeaponName(): String = currentWeapon.name

    fun getRifle() {
        currentWeapon = Weapons.RIFLE
    }

    fun getPistol() {
        currentWeapon = Weapons.PISTOL
    }

    fun getMachineGun() {
        currentWeapon = Weapons.MACHINE_GUN
    }
}
