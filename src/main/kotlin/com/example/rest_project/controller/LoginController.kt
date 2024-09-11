package com.example.rest_project.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun showLoginPage(): String {
        return "login"
    }


}