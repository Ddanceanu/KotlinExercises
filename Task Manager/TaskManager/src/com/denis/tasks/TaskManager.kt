package com.denis.tasks

class TaskManager {
    private val tasksList = ArrayList<Task>()
    var nextId = 1

    fun addTask(task: Task) {
        task.id = nextId++
        tasksList.add(task)
    }

    fun getTasks(): List<Task> = tasksList
}
