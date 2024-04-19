package dev.surratt.gurps.equip.dsl.domain

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class DomainClassTests {

    @Test
    fun `two arg constructor sets modifier to zero`() {

        val weaponDamage = StrengthBasedDamage(MeleeWeaponType.thrust, DamageType.impaling)

        assertEquals(0, weaponDamage.modifier)

    }

}