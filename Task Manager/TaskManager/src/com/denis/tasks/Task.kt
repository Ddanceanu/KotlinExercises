package com.denis.tasks

enum class Status(
    val description: String,
) {
    PENDING("Task is pending"),
    IN_PROGRESS("Task is in progress"),
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
}
