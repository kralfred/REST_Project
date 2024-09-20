package com.example.rest_project.controller

import com.example.rest_project.entity.Role
import com.example.rest_project.entity.User
import com.example.rest_project.repository.RegisterMapper
import com.example.rest_project.service.RegisterService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.ui.Model
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@Controller
class RegisterController (
    private val registerService: RegisterService
){

    @GetMapping("/register")
    fun displayRegisterPage(model: Model): String {
        model.addAttribute("user", User())
        return "register"
    }

    @PostMapping("/newuser")
    fun addUser(@ModelAttribute user: User, model: Model): String {
        println("function called")

        try{

            registerService.createUser(user)
            return "register"


        }
        catch (E: Exception){
            model.addAttribute("error", "Failed to register user.")
        }
        return "register"
    }




}