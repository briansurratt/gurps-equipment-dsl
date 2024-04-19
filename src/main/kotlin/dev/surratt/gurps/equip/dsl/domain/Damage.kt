package dev.surratt.gurps.equip.dsl.domain

enum class DamageType {
    burning,crushing,cutting,impaling,smallPiercing, piercing, largePiercing
}

enum class MeleeWeaponType {
    swung, thrust
}

data class StrengthBasedDamage(val type: MeleeWeaponType,
                              val damageType: DamageType,
                              val modifier: Int) {

    constructor(type: MeleeWeaponType,damageType: DamageType) :
            this(type, damageType, 0) {
    }

}