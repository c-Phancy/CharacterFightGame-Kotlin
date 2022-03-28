/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/02/09
 *  Assignment:   Character Fight
 *  Class Number: CIS 283
 *  Description:  Create a game that simulates two characters with set attributes from a text import fighting each other to the death
 ************************************************************/
class Character(
    val name: String = "Default",
    private val race: String = "Default",
    private var hitPoints: Int = 0,
    private var strength: Int = 0,
    private var agility: Int = 0,
    val weapon: Weapons = Weapons(),
    private val armor: Armor = Armor(),
) {
    private val maxHitPoints = 100
    private val maxStrength = 50
    private val maxAgility = 10

    init {
        // Restrict Hit Points
        if (hitPoints !in 0..maxHitPoints) {
            if (hitPoints > maxHitPoints) {
                hitPoints = maxHitPoints
            } else {
                hitPoints = 0
            }
        }
        // Restrict Strength
        if (strength !in 0..maxStrength) {
            if (strength > maxStrength) {
                strength = maxStrength
            } else {
                strength = 0
            }
        }
        // Restrict Agility
        if (agility !in 0..maxAgility) {
            if (agility > maxAgility) {
                agility = maxAgility
            } else {
                agility = 0
            }
        }
    }

    private var currentHitPoints = hitPoints

    fun currentStatus() {
        println("$name has $currentHitPoints left out of $hitPoints.")
    }
    // Return version
    fun currentStatusReturn(): String {
        return "$name has $currentHitPoints left out of $hitPoints."
    }

    fun reviveCharacter() {
        currentHitPoints = hitPoints
    }

    fun reduceHits(initialDamage: Int): Int {
        // Calculate Points Deflected
        fun savePoints(initialDamage: Int): Int {
            val armorSave = armor.protectionHits / Dice(15).roll()
            return if (armorSave >= initialDamage) {
                initialDamage
            } else {
                armorSave
            }
        }
        val savePoints = savePoints(initialDamage)
        return if ((initialDamage - savePoints) > 0) {
            initialDamage - savePoints
        } else {
            0
        }
    }


    // Calculate Current Hit Points
    fun applyDamage(reducedDamage: Int) {
        currentHitPoints -= reducedDamage
        if (currentHitPoints < 0) {
            currentHitPoints = 0
        }
    }

    // Ensures reroll (update die value each turn)
    fun realHit(): Int {
        return (strength * (1.0 / Dice(4).roll()) + (weapon.damageHits / Dice(8).roll())).toInt()
    }

    // Return Private Variables
    fun getStat(): HashMap<String, Int> {
        val stats = hashMapOf("agility" to agility, "currentHitPoints" to currentHitPoints)
//        stats["agility"] = agility
//        stats["currentHitPoints"] = currentHitPoints
        return stats
    }

    override fun toString(): String {
        return """
            |Name:     $name
            |Race:     $race
            |Hit
            |Points:   $hitPoints
            |Strength: $strength
            |Agility:  $agility
            |$weapon
            |$armor
        """.trimMargin()
    }
}