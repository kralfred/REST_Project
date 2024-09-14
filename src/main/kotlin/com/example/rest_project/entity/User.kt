package com.example.rest_project.entity

import java.util.UUID


data class User(

    var name: String? = null,
    var password: String? = null,
    val role: Role = Role.USER,
    val email: String? = null,
    var userID: UUID? = null,
)
enum class Role {
    USER, ADMIN, MANAGER
}