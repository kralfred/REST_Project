package com.example.rest_project.security

import com.example.rest_project.entity.AuthenticationRequest
import com.example.rest_project.entity.AuthenticationResponse
import com.example.rest_project.service.CustomUserDetailService
import com.example.rest_project.service.TokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import java.util.*


@Service
class AuthenticationService(
    private val tokenService: TokenService,
    private val authManager: AuthenticationManager,
    private val customUserDetailService: CustomUserDetailService,
    private val jwtProperties: JwtProperties
) {

     fun authentication(authRequest: AuthenticationRequest): AuthenticationResponse {

        authManager.authenticate(UsernamePasswordAuthenticationToken(authRequest.email, authRequest.password))

        val token = tokenService.generate(
            userDetails = customUserDetailService.loadUserByUsername(authRequest.email),
            expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
        )
        return AuthenticationResponse(token)
    }
}