package com.example.rest_project.entity

import java.util.*

data class Comment(
    val taskID: UUID,
    val id: UUID = UUID.randomUUID(),
    var text: String

)
