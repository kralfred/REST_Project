package com.example.rest_project.controller

import com.example.rest_project.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
  class UserController (
    taskService: TaskService
  ){
      @GetMapping("/")
      fun welcome(): String {

        return("index")
      }




  }