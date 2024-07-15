package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import com.example.rest_project.entity.Comment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.swing.Action


@Controller
class TaskController {

    private val tasks = mutableListOf<Task>()
    private val comments = mutableListOf<Comment>()

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

    @PostMapping("/handleTasks")
    fun handleTasks(@RequestParam checkBoxes: List<UUID>?,@RequestParam taskBtn: String): String {



        when(taskBtn){
            "remove" -> if (checkBoxes != null) {
                tasks.removeIf { task -> checkBoxes.contains(task.id) }
            }
            "mark" -> if (checkBoxes != null) {
                println("marked")
                tasks.forEach{ task -> task.finished = checkBoxes?.contains(task.id) == true}
        }
        }




        return "redirect:/"
    }



    @PostMapping("/editTask")
    fun editTask(@RequestParam uuid: String, @RequestParam status: String) : String {

     return "redirect:/"
    }
    @PostMapping("/markAsDone")
    fun markAsDone(@RequestParam checkBoxes: List<UUID>?){

    }

}

