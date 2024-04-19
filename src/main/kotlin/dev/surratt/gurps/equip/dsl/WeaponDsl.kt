package dev.surratt.gurps.equip.dsl

import dev.surratt.gurps.equip.dsl.domain.*

fun melee(block: MeleeWeaponBuilder.() -> Unit): MeleeWeapon {
    return MeleeWeaponBuilder().apply(block).build()
}

class MeleeWeaponBuilder {

    var technologyLevel : Int? = null
    var name: String? = null
    var weight: Int? = null
    var requiredStrength: Int? = null
    var damage: StrengthBasedDamage? = null

    fun build() : MeleeWeapon = MeleeWeapon(name!!,
            weight!!,
            requiredStrength!!,
            damage!!,
            technologyLevel!!
    )

    fun damage(block: StrengthBasedDamageBuilder.() -> Unit) {
        damage = StrengthBasedDamageBuilder().apply(block).build()
    }

}

fun ranged(block: StrengthBasedWeaponBuilder.() -> Unit) : StrengthBasedRangedWeapon {
    return StrengthBasedWeaponBuilder().apply(block).build()
}

class StrengthBasedWeaponBuilder {

    var name: String? = null
    var technologyLevel: Int? = null
    var accuracy: Int? = null
    var range: StrengthBasedWeaponRange? = null
    var weight: Int? = null
    var ammoWeight: Double? = null
    var rateOfFire: Int? = null
    var shots: Int? = null
    var reload: Int? = null
    var requiredStrength: Int? = null
    var damage: StrengthBasedDamage? = null

    fun build(): StrengthBasedRangedWeapon = StrengthBasedRangedWeapon(
            name!!,
            technologyLevel!!,
            accuracy!!,
            range!!,
            weight!!,
            ammoWeight!!,
            rateOfFire!!,
            shots!!,
            reload!!,
            requiredStrength!!,
            damage!!
    )

    fun damage(block: StrengthBasedDamageBuilder.() -> Unit) {
        damage = StrengthBasedDamageBuilder().apply(block).build()
    }

    fun range(block: StrengthBasedWeaponRangeBuilder.() -> Unit) {
        range = StrengthBasedWeaponRangeBuilder().apply(block).build()
    }

}

class StrengthBasedWeaponRangeBuilder {
    var max: Int? = null
    var half: Int? = null
    fun build(): StrengthBasedWeaponRange = StrengthBasedWeaponRange(half!!, max!!)
}

class StrengthBasedDamageBuilder {
    var damageType : DamageType? = null
    var type : MeleeWeaponType? = null
    var modifier: Int = 0
    fun build() : StrengthBasedDamage = StrengthBasedDamage(type!!, damageType!!, modifier)
}