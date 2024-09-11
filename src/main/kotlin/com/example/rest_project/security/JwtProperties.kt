package com.example.rest_project.security


import org.springframework.boot.context.properties.ConfigurationProperties




@ConfigurationProperties("jwt")
data class JwtProperties(

    var accessTokenExpiration: Long,
    var refreshTokenExpiration: Long,
)
