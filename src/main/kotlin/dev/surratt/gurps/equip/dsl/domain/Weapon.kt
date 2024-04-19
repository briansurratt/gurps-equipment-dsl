package dev.surratt.gurps.equip.dsl.domain

data class MeleeWeapon(val name: String,
                       val weight: Int,
                       val requiredStrength: Int,
                       val damage: StrengthBasedDamage,
                       val technologyLevel: Int)

data class StrengthBasedRangedWeapon(val name: String,
                                     val technologyLevel: Int,
                                     val accuracy: Int,
                                     val range: StrengthBasedWeaponRange,
                                     val weight: Int,
                                     val ammoWeight: Double,
                                     val rateOfFire: Int,
                                     val shots: Int, // this is the number of shots which be take before the weapon must be reloaded
                                     val reload: Int,
                                     val requiredStrength: Int,
                                     val damage: StrengthBasedDamage
)


// for strength based weapon ranges the half and max values are multiples of the character's Strength
data class StrengthBasedWeaponRange(val half: Int,
                                    val max: Int)  {

}



