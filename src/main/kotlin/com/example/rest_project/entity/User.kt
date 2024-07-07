package com.example.rest_project.entity

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
 class User(

    val id: Long,
    val userName: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val userId: Long = 0
)