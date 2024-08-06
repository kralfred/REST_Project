package com.example.rest_project.entity

import java.util.*

data class CustomerFilter(
    val id: UUID = UUID.randomUUID(),
    var fullText: String? = null
)