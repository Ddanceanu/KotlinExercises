package com.denis.tasks

enum class Status(
    val description: String,
) {
    PENDING("Task is pending"),
    INPROGRESS("Task is in progress"),
    COMPLETED("Task is completed"),
    CANCELLED("Task is cancelled"),
    ;

    fun getStatusDescription(): String = description
}

enum class Priority {
    Low,
    Medium,
    High,
    Critical,
}

data class Task(
    var title: String,
) {
    var id: Int = 0
    var description: String? = null
    var dueDate: String? = null
    var priority: Priority? = null
    var status: Status? = null

    fun addDescription() {
        print("Task Description: ")
        val taskInput = readLine() ?: ""
        description = if (!taskInput.isBlank()) taskInput else "No description provided"
    }

    fun addDate() {
        print("Due Date: ")
        val taskInput = readLine() ?: ""
        dueDate = if (!taskInput.isBlank()) taskInput else "No date provided"
    }

    fun addPriority() {
        print("Priority (Low/Medium/High/Critical): ")
        val taskInput = readLine() ?: ""
        try {
            priority = Priority.valueOf(taskInput.replaceFirstChar { it.uppercaseChar() })
        } catch (e: IllegalArgumentException) {
            println("Incorrect argument! Converting into 'Low'")
            priority = Priority.Low
        }
    }

    fun addStatus() {
        status = Status.PENDING
    }

    fun modifyStatus() {
        print("Status (PENDING/IN_PROGRESS/COMPLETED/CANCELLED): ")
        val input = readLine() ?: ""
        try {
            status = Status.valueOf(input.uppercase())
        } catch (e: IllegalArgumentException) {
            println("Incorrect argument! Converting into 'PENDING'")
            status = Status.PENDING
        }
    }
}
