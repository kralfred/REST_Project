package com.example.rest_project.entity

import java.util.*


data class Task (
    val taskID: Int? = null,
    var name: String,
    var complete: Boolean

)