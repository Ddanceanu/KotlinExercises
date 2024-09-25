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
                val name = readLine() ?: ""
                val newTask = Task(name)
                taskManager.addTask(newTask)
            }
            "list" -> {
                val myTasksList = taskManager.getTasks()
                for (i in myTasksList) {
                    println("Task ID: ${i.id}, Title: ${i.title}")
                }
            }
            "exit" -> break
        }
    }
}
