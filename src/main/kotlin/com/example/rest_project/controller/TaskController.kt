package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*

@Controller
class TaskController {

    private val tasks = mutableListOf<Task>()

    @GetMapping("/")
    fun showTasks(model: Model): String {
        model.addAttribute("tasks", tasks)
        return "index"
    }



    @PostMapping("/btn/{name}/")
    fun evaluate(@PathVariable name: String,
                 @RequestParam status: String,
                 @RequestParam action: String,
                 @RequestParam uuid: String): String

    {
       when (action){
           "addBtn" -> addTask(name = name, status = status)

           "removeBtn" -> println("deleted")

           "removeBtn" -> println("removed")

       }
        return "redirect:/"
    }


    @PostMapping("/btn")
    fun addTask(name: String,status: String): String {
        tasks.add(Task(name=name, status=status))
        return "redirect:/"
    }

    @PostMapping("/removeTask")
    fun removeTask(@RequestParam uuid: String): String {
        val uuidParsed = UUID.fromString(uuid)
        val wasRemoved = tasks.removeIf { it.id == uuidParsed }


        return "redirect:/"
    }

  /*  @PostMapping("/editTask")
    fun editTask(@RequestParam uuid: String, @RequestParam status: String) : String {
        val

    }*/


}

