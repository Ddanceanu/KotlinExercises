package com.denis.tasks

class TaskManager {
    private val tasksList = ArrayList<Task>()
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
}
