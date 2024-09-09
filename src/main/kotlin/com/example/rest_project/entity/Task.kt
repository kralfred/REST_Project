package com.example.rest_project.entity

import java.time.LocalDate
import java.util.*


data class Task (

    var name: String,
    var complete: Boolean,
    var date: LocalDate,
    val task_id: UUID

    )