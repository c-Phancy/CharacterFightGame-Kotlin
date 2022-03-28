/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/02/09
 *  Assignment:   Character Fight
 *  Class Number: CIS 283
 *  Description:  Create a game that simulates two characters with set attributes from a text import fighting each other to the death
 ************************************************************/
class Dice(var num_sides: Int) {
    var sidesOfDie = num_sides

    fun roll(): Int {
        return (1..num_sides).random()
    }
}