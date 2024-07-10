package com.example.rest_project.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


data class User(

    val id: Long,
    val userName: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long = 0
)