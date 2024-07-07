package com.example.rest_project.entity


data class Task(
    val id: Long,
    var title: String,
    var description: String,
    var completed: Boolean
)
