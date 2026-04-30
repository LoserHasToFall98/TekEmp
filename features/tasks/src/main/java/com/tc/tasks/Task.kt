package com.tc.tasks
import java.time.LocalDateTime

data class Task (
    val id: String,
    val title: String,
    val type: TaskType,
    val dueDate: LocalDateTime,
    val priority: Boolean,
    val assignedBy: String
)
enum class TaskType{
    ALL, TODAY, UPCOMING
}
