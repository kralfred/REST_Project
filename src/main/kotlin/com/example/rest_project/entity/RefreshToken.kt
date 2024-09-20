package com.example.rest_project.entity

import java.time.LocalDateTime
import java.util.UUID

data class RefreshToken(
    val refreshTokenID: UUID? = null,
    val token: String,
    var userId: UUID,
    val expirationDate: LocalDateTime
)
