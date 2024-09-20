package com.example.rest_project.controller

import com.example.rest_project.entity.User
import org.springframework.ui.Model

import com.example.rest_project.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping



@Controller
@RequestMapping("/users")
class UserController(private val userService: UserService) {


    @GetMapping("/create")
    fun showCreateUserForm(model: Model): String {
        model.addAttribute("user", User())
        return "create-user"
    }

//    @PostMapping
//    fun createUser(@ModelAttribute("user") user: User): String {
//        userService.createUser(user)
//        return "redirect:/users/create"
//    }


}

