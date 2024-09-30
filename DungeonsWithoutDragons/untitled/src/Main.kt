import com.dungeons.Map
import com.dungeons.Player

fun main() {
    println("Welcome to \"Dungeons without dragons\"!")
    print("Please enter your name: ")
    val playerName = readLine() ?: "Anonymous"
    val player = Player(playerName)
    val gameMap = Map(player)
    println("Hello, $playerName! You are now exploring the dungeon!")
    while (true) {
        gameMap.displayNextMove()
        gameMap.readNextMove()
    }
}
