package com.example.rest_project.entity

import java.util.*


data class Task(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val status: String,
    var completed: Boolean = false
)
