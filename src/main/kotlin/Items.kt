/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/02/09
 *  Assignment:   Character Fight
 *  Class Number: CIS 283
 *  Description:  Create a game that simulates two characters with set attributes from a text import fighting each other to the death
 ************************************************************/
open class Item(val name: String) {

    override fun toString(): String {
        return name
    }

}

class Weapons(name: String = "Default", val damageHits: Int = 0): Item(name) {
    override fun toString(): String {
        return "Weapon:   ${super.toString()} ($damageHits Attack Points)"
    }
}

class Armor(name: String = "Default", val protectionHits: Int = 0): Item(name) {
    override fun toString(): String {
        return "Armor:    ${super.toString()} (${protectionHits} Defense Points)"
    }
}