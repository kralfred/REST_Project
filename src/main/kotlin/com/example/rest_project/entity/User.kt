package com.example.rest_project.entity

import java.util.UUID


data class User(

    var name: String? = null,
    var email: String? = null,
    var role: Role = Role.USER,
    var userID: UUID = UUID.randomUUID(),
    var password: String? = null,
){
    override fun toString(): String {
        return "User(name=$name, email=$email, role=$role, userID=$userID, password=$password)"
    }
}
enum class Role {
    USER, ADMIN, MANAGER
}