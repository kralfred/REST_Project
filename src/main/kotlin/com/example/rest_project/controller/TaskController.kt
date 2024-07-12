package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

import org.springframework.web.bind.annotation.GetMapping

@Controller
class SecondaryPageController {

    @GetMapping("/secondary")
    fun secondaryPage(model: Model): String {
        model.addAttribute("message", "This is the secondary page!")
        return "secondary" // Name of the Thymeleaf template
    }
}




@Controller
class TaskController {

    private val tasks = mutableListOf<Task>()

    @GetMapping("/")
    fun showTasks(model: Model): String {
        model.addAttribute("tasks", tasks)
        return "index"
    }

    @GetMapping("/btn/{name}/")
    fun handleButton(@PathVariable name: String): String{


        return "Button pressed: $name"
    }




    @PostMapping("/addTask")
    fun addTask(name: String,status: String): String {
        tasks.add(Task(name=name, status=status))
        return "redirect:/"
    }


    @PostMapping("/removeTasks")
    fun removeTasks(@ModelAttribute("tasks") checkedTasks: List<Task>): String {
        tasks.removeIf { task -> checkedTasks.any { it.id == task.id && !it.checked } }
        return "redirect:/"
    }

    @PostMapping("/remTask")
    fun reemoveTask(@RequestParam uuid: String): String {
        val uuidParsed = UUID.fromString(uuid)
        val wasRemoved = tasks.removeIf { it.id == uuidParsed }


        return "redirect:/"
    }

  /*  @PostMapping("/editTask")
    fun editTask(@RequestParam uuid: String, @RequestParam status: String) : String {
        val

    }*/


}

