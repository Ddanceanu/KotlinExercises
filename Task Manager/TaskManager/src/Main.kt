import com.denis.tasks.Task
import com.denis.tasks.TaskManager

fun main() {
    println("Welcome to Task Manager")
    val taskManager = TaskManager()
    println("Available commands: add, edit, list, filterList, delete,  exit")
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
            "edit" -> {
                println("Pentru a edita un task, ai nevoie de ID-ul acestuia. Il poti obtine folosind comanda \"list\".")
                val input = readLine() ?: ""
                val taskId = input.toIntOrNull() ?: 0

                if (input == "list") {
                    taskManager.printTasks()
                    continue
                } else {
                    if (taskId in 1..taskManager.nextId - 1) {
                        print("Ce camp doriti sa modificati? (Description/Date/Priority/Status): ")
                        val input = readLine() ?: ""
                        taskManager.editTask(taskId, input)
                    } else {
                        println("ID incorect.")
                        continue
                    }
                }
            }
            "delete" -> {
                println("Pentru a sterge un task, ai nevoie de ID-ul acestuia. Il poti obtine folosind comanda \"list\".")
                val input = readLine() ?: ""
                val taskId = input.toIntOrNull() ?: 0
                if (input == "list") {
                    taskManager.printTasks()
                    continue
                } else {
                    if (taskId in 1..taskManager.nextId) {
                        try {
                            val success = taskManager.deleteTask(taskId)
                            if (success) {
                                println("Task-ul cu ID-ul $taskId a fost sters cu succes!")
                            }
                        } catch (e: Exception) {
                            println("A aparut o eroare la stergerea task-ului")
                        }
                    } else {
                        println("ID incorect.")
                        break
                    }
                }
            }
            "filterList" -> {
                print("Dupa ce criteriu vreti sa afisati ordinea task-urilor? (Priority/Status): ")
                val input = readLine() ?: ""
                taskManager.filterBy(input)
            }
            "exit" -> break
            else -> {
                println("Unknown command: $input")
            }
        }
    }
}
