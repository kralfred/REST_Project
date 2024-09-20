package com.example.rest_project.controller

import com.example.rest_project.entity.AuthenticationRequest
import com.example.rest_project.entity.AuthenticationResponse
import com.example.rest_project.security.AuthenticationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {
    @PostMapping
    fun authenticate(@RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
        authenticationService.authentication(authRequest)



}