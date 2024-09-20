package com.example.rest_project.entity

data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: RefreshToken

)
