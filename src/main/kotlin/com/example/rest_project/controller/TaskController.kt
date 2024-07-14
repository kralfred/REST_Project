package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*






@Controller
class TaskController {

    private val tasks = mutableListOf<Task>()

    @GetMapping("/")
    fun showTasks(model: Model): String {
        model.addAttribute("tasks", tasks)
        return "index"
    }





    @PostMapping("/addTask")
    fun addTask(name: String,status: String): String {
        tasks.add(Task(name=name, status=status))
        return "redirect:/"
    }

    @PostMapping("/removeTasks")
    fun removeTasks(@RequestParam checkBoxes: List<UUID>?): String {

        if (checkBoxes != null) {

            tasks.removeIf { task -> checkBoxes.contains(task.id) }

        }

        return "redirect:/"
    }



  /*  @PostMapping("/editTask")
    fun editTask(@RequestParam uuid: String, @RequestParam status: String) : String {
        val

    }*/


}

