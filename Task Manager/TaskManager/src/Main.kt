import com.denis.tasks.Task
import com.denis.tasks.TaskManager

fun main() {
    println("Welcome to Task Manager")
    val taskManager = TaskManager()
    println("Available commands: add, edit, print, delete, exit")
    while (true) {
        print("Enter command: ")
        val input = readLine() ?: ""
        when (input) {
            "add" -> {
                print("Task name: ")
                val newTask = Task(readLine() ?: "")

                newTask.addDescription()
                newTask.addDate()
                newTask.addPriority()
                newTask.addStatus()

                taskManager.addTask(newTask)
            }
            "list" -> taskManager.printTasks()
            "exit" -> break
            else -> {
                println("Unknown command: $input")
            }
        }
    }
}
