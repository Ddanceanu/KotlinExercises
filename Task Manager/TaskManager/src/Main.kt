import com.denis.tasks.Priority
import com.denis.tasks.Status
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
                var taskInput = readLine() ?: ""
                val newTask = Task(taskInput)
                print("Task Description: ")
                taskInput = readLine() ?: ""
                newTask.description = if (!taskInput.isBlank()) taskInput else "No description provided"
                print("Due Date: ")
                taskInput = readLine() ?: ""
                newTask.dueDate = if (!taskInput.isBlank()) taskInput else "No date provided"
                print("Priority (Low/Medium/High/Critical): ")
                taskInput = readLine() ?: ""
                try {
                    newTask.priority = Priority.valueOf(taskInput.replaceFirstChar { it.uppercaseChar() })
                } catch (e: IllegalArgumentException) {
                    println("Incorrect argument! Converting into 'Low'")
                    newTask.priority = Priority.Low
                }
                taskManager.addTask(newTask)
                newTask.status = Status.PENDING
            }
            "list" -> taskManager.printTasks()
            "exit" -> break
        }
    }
}
