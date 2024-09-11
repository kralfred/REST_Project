package com.example.rest_project.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID


data class User(

    var name: String,
    val password: String,
    val role: Role,
    val email: String,
    val userID: UUID,
)
enum class Role {
    USER, ADMIN, MANAGER
}