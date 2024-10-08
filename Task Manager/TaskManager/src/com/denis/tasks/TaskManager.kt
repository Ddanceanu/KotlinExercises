package com.denis.tasks

class TaskManager {
    private var tasksList = ArrayList<Task>()
    var nextId = 1

    fun addTask(task: Task) {
        task.id = nextId++
        tasksList.add(task)
    }

    fun getTasks(): List<Task> = tasksList

    fun printTasks() {
        for (task in tasksList) {
            println("----------- Task ID: ${task.id} ----------- ")
            println("Title:        ${task.title}")
            println("Description:  ${task.description}")
            println("Due Date:     ${task.dueDate}")
            println("Priority:     ${task.priority}")
            println("Status:       ${task.status}")
            println("----------------------------------")
        }
    }

    fun deleteTask(id: Int): Boolean = tasksList.removeIf { task -> task.id == id }

    fun editTask(
        id: Int,
        field: String,
    ) {
        val task = tasksList.find { task -> task.id == id }
        if (task != null) {
            when (field.lowercase()) {
                "description" -> task.addDescription()
                "dueDate" -> task.addDate()
                "priority" -> task.addPriority()
                "status" -> task.modifyStatus()
                else -> println("Camp invalid.")
            }
        }
    }

    fun filterBy(field: String) {
        when (field.lowercase()) {
            "priority" -> {
                var newList = tasksList
                tasksList.sortByDescending { task -> task.priority }
                printTasks()
                tasksList = newList
            }
            "status" -> {
                var newList = tasksList
                tasksList.sortBy { task -> task.status }
                printTasks()
                tasksList = newList
            }
        }
    }
}
