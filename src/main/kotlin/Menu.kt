/************************************************************
 *  Name:         Christina Phan
 *  Date:         2022/01/20
 *  Assignment:
 *  Class Number: CIS 283
 *  Description:
 ************************************************************/
class Menu(var menuItems: List<String>, var prompt: String) {
    val quit = menuItems.size

    private fun getInt(prompt: String, range: IntRange): Int {
        var choice = 0
        do {
            print(prompt)
            choice = readLine()?.toIntOrNull() ?: 0
        } while (choice !in range)
        return choice
    }

    fun displayMenu(): Int {
        for((index, item) in menuItems.withIndex()) {
            println("${index + 1}. $item")
        }
            return getInt(prompt, 1..menuItems.size)
    }
}