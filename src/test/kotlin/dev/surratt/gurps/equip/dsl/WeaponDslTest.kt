package dev.surratt.gurps.equip.dsl

import dev.surratt.gurps.equip.dsl.domain.DamageType
import dev.surratt.gurps.equip.dsl.domain.MeleeWeaponType
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class WeaponDslTest {

    @Test
    fun `melee weapon function builds a weapon`() {
        val meleeWeapon = melee {
            technologyLevel = 0
            requiredStrength = 27
            name = "huge sword"
            weight = 10
            damage {
                type = MeleeWeaponType.swung
                damageType = DamageType.burning
            }
        }

        val damageDef = meleeWeapon.damage
        assertNotNull(damageDef)
        assertEquals(MeleeWeaponType.swung, damageDef.type)
        assertEquals(DamageType.burning, damageDef.damageType)

    }

    @Test
    fun `StrengthBasedWeaponRangeBuilder sets half and max appropriately`() {

        val builder = StrengthBasedWeaponRangeBuilder()
        builder.max = 27
        builder.half = 19

        val range = builder.build()
        assertEquals(19, range.half)
        assertEquals(27, range.max)

    }

}