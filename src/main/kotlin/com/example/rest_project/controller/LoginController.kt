package com.example.rest_project.controller

import org.slf4j.LoggerFactory
import org.slf4j.Logger

import com.example.rest_project.entity.AuthenticationRequest
import com.example.rest_project.entity.AuthenticationResponse
import com.example.rest_project.security.AuthenticationService
import com.example.rest_project.service.RefreshTokenService
import org.springframework.ui.Model
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class LoginController(
    private val authenticationService: AuthenticationService,
    private val refreshTokenService: RefreshTokenService,

    ){

    private val logger: Logger = LoggerFactory.getLogger(LoginController::class.java)

    @GetMapping("/login")
    fun showLoginPage(model: Model): String {
        model.addAttribute("user", AuthenticationRequest())

        return "login"
    }


    @PostMapping("/logincheck")
    fun login(@ModelAttribute request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        logger.info("Login attempt for user: {}", request.email)
        val response = authenticationService.authentication(request)
        refreshTokenService.createAndStoreRefreshToken(response.refreshToken)

        println("working")
        return ResponseEntity.ok(response)


    }


}
