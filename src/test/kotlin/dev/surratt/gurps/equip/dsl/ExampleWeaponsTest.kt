package dev.surratt.gurps.equip.dsl

import dev.surratt.gurps.equip.dsl.domain.DamageType
import dev.surratt.gurps.equip.dsl.domain.MeleeWeaponType
import org.junit.Test

class ExampleWeaponsTest {

    // the weapons defined here are key examples from the
    // gurps lite documentation.  if they compile and run
    // then the DSL can represent common weapons in the
    // game

    @Test
    fun `melee weapons can be modeled`() {

        val axe = melee {
            technologyLevel = 0
            name = "axe"
            weight = 4
            requiredStrength = 11
            damage {
                type = MeleeWeaponType.swung
                damageType = DamageType.cutting
                modifier = 2
            }
        }

        val punch = melee {
            technologyLevel = 0
            name = "punch"
            weight = 0
            requiredStrength = 0
            damage {
                type = MeleeWeaponType.thrust
                damageType = DamageType.crushing
                modifier = -1
            }
        }

    }

    @Test
    fun `muscle-powered ranged weapons can be modeled`() {

        val longbow = ranged {
            technologyLevel = 0
            name = "longbow"
            accuracy = 3
            range {
                half = 15
                max = 20
            }
            weight = 3
            ammoWeight = 0.1
            rateOfFire = 1
            shots = 1
            reload = 2
            requiredStrength = 11
            damage {
                type = MeleeWeaponType.thrust
                damageType = DamageType.impaling
                modifier = 2
            }
        }

    }

}