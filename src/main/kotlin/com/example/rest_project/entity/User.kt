package com.example.rest_project.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID


data class User(

    var name: String,
    var password: String,
    var role: String,
    var email: String,
    val userID: UUID,
)