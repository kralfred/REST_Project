// src/main/kotlin/com/example/demo/controller/MyController.kt
package com.example.rest_project.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class Testing {

    @GetMapping("/secondary")
    fun displayCheckboxForm(model: Model): String {
        // Add any necessary attributes to the model here
        return "secondary" // Name of the Thymeleaf template for the secondary page
    }

    @GetMapping("/checked")
    fun check(model: Model): String? {
        val engine = Engine(true)
        model.addAttribute("engine", engine)
        model.addAttribute("flag", true)
        return "secondary"
    }
    @GetMapping("/post")
    fun post(model:Model){

    }

    private class Engine(val active: Boolean)
}



