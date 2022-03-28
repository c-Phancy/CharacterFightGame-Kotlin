import java.io.File

/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/02/09
 *  Assignment:   Character Fight
 *  Class Number: CIS 283
 *  Description:  Create a game that simulates two characters with set attributes from a text import fighting each other to the death
 ************************************************************/
fun main() {
    var character1 = Character()
    var character2 = Character()
    val menuItems = mutableListOf("Load Character 1", "Load Character 2", "Fight", "Quit")
    val menu = Menu(menuItems, "Please select an option: ")
    do {
        val choice = menu.displayMenu()
        when (choice) {
            1 -> {
                character1 = findCharacter("gimli.txt")
                menuItems[0] = "Character 1: ${character1.name}"
            }
            2 -> {
                character2 = findCharacter("legolas.txt")
                menuItems[1] = "Character 2: ${character2.name}"
            }
            3 -> {
                character1.reviveCharacter()
                character2.reviveCharacter()
                val results = game(character1, character2)
                println("${results["winner"]!!.first.name} WINS!")
                println("""
                    ${"-".repeat(25)}
                    ${results["loser"]?.second}
                    ${results["winner"]?.second}
                    ${"-".repeat(25)}
                """.trimIndent())
                println()
            }
            else -> {
                println("Ending...")
            }
        }
    } while (choice != menu.quit)
}

fun unpackCharacter(fileName: String): Character {
    val filePath = "src/$fileName"
    val lines = mutableListOf<String>()
    val lineSplit = mutableListOf<String>()
    File(filePath).forEachLine {
         lineSplit += it.split(",")
    }
    lineSplit.forEach {
        lines += it.trimStart()
    }

    val weapon = Weapons(lines[5], lines[6].toInt())
    val armor = Armor(lines[7], lines[8].toInt())
    return Character(lines[0], lines[1], lines[2].toInt(), lines[3].toInt(), lines[4].toInt(), weapon, armor)
}

fun findCharacter(default: String): Character {
    var userChoice: Character?
    do {
        print("Please enter character file: ")
        userChoice = try {
            unpackCharacter(readLine()!!)
        } catch (e: java.io.FileNotFoundException) {
            // null
            // for testing purposes, file will be filled in
            unpackCharacter(default)
        }
    } while (userChoice == null)
    println()
    return userChoice
}

fun game(character1: Character, character2: Character): HashMap<String, Pair<Character, String>> {


    // Trade blows
    var end: Boolean
    val results = HashMap<String, Pair<Character, String>>() // Pair String = currentStatusReturn()
    do {
        // Decide who goes first
        var char1Roll: Int
        var char2Roll: Int
        do {
            char1Roll = Dice(character1.getStat()["agility"]!!).roll()
            char2Roll = Dice(character2.getStat()["agility"]!!).roll()
        } while (char1Roll == char2Roll)
        val firstTurn: Character
        val secondTurn: Character
        if (char1Roll > char2Roll) {
            firstTurn = character1
            secondTurn = character2
        } else {
            firstTurn = character2
            secondTurn = character1
        }
        println()
        end = turn(firstTurn, secondTurn)
        if (!end) {
            end = turn(secondTurn, firstTurn)
            if (end) {
                results["winner"] = Pair(secondTurn, secondTurn.currentStatusReturn())
                results["loser"] = Pair(firstTurn, firstTurn.currentStatusReturn())
            }
        } else {
            results["winner"] = Pair(firstTurn, firstTurn.currentStatusReturn())
            results["loser"] = Pair(secondTurn, secondTurn.currentStatusReturn())
        }
        if (!end) {
            print("\nHit return to continue ...")
            readLine()!!
            println()
        }
    } while (!end)
    println()
    return results
}

fun turn(character: Character, opponent: Character): Boolean {
    println("${character.name} fights with the ${character.weapon.name}:")
    val roll = Dice(10).roll()
    if (roll < character.getStat()["agility"]!!) {
        val realHit = character.realHit()
        val realDamage = opponent.reduceHits(realHit)
        println("\tHit: $realHit")
        println("\t${opponent.name}${possessiveMod(opponent.name)} armor saved ${realHit - realDamage} points.")
        println("${opponent.name}${possessiveMod(opponent.name)} hits are reduced by $realDamage points.")
        opponent.applyDamage(realDamage)
    } else {
        println("\tMisses!")
    }
    opponent.currentStatus()
    // Check win
    return opponent.getStat()["currentHitPoints"] == 0
}

fun possessiveMod(name: String): String {
    return if (name.last() != 's') {
        "'s"
    } else {
        "'"
    }
}