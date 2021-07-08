import java.lang.NumberFormatException
import kotlin.system.exitProcess

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            if (args.size != 1) {
                System.err.println("Error\n\tUsage: java -jar Maze.jar <path mode>")
                exitProcess(1)
            }

            val pathMode = try {
                args[0].toInt()
            } catch (e: NumberFormatException) {
                System.err.println ("Error\n\t${args[0]} is not a valid number")
                exitProcess(2)
            }.apply {
                if (!PathFactory.valid(this)) {
                    System.err.println ("Error\n\t${this} is an invalid path mode")
                    exitProcess(3)
                }
            }

            val game = Game(20, 0, 0, 0, 0, 9, PathFactory.generate(pathMode))
            println(game.maze)
        }
    }
}