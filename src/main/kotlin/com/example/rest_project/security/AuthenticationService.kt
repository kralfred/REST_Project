package com.example.rest_project.security

import com.example.rest_project.entity.AuthenticationRequest
import com.example.rest_project.entity.AuthenticationResponse
import com.example.rest_project.entity.RefreshToken
import com.example.rest_project.service.CustomUserDetailService
import com.example.rest_project.service.TokenService
import com.example.rest_project.service.UserService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Service
class AuthenticationService(
    private val tokenService: TokenService,
    private val authManager: AuthenticationManager,
    private val customUserDetailService: CustomUserDetailService,
    private val jwtProperties: JwtProperties,
    private val userService: UserService
) {

     fun authentication(authRequest: AuthenticationRequest): AuthenticationResponse {

         try{


        authManager.authenticate(UsernamePasswordAuthenticationToken(authRequest.email, authRequest.password))



        val token = tokenService.generate(
            userDetails = customUserDetailService.loadUserByUsername(authRequest.email),
            expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
        )

         val expirationDate = LocalDateTime.ofInstant(
             Date(System.currentTimeMillis() + jwtProperties.refreshTokenExpiration).toInstant(),
             ZoneId.systemDefault()
         )

         val refreshToken = UUID.randomUUID().toString()
         val refreshTokenEntity = RefreshToken(
             token = refreshToken,
             userId = userService.getByEmail(authRequest.email).userID,
             expirationDate = expirationDate
         )

        return AuthenticationResponse(token, refreshTokenEntity)
     }
         catch (e: Exception) {


             throw BadCredentialsException("Invalid email or password")
         }
    }





}