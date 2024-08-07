package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import com.example.rest_project.repository.TaskMapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*


@Controller
class TaskController(
    private val taskMapper: TaskMapper
){



    @GetMapping("/")
    fun showTasks(model: Model): String {
        model.addAttribute("tasks", taskMapper.getAll())
        return "index"
    }


    @PostMapping("/addTask")
    fun addTask(@RequestParam name: String): String {
        println("Task added")
        val taskInstance = Task( name = name , complete = false)
        taskMapper.insert(taskInstance)

        return "redirect:/"
    }

    @PostMapping("/getTaskByName")
    fun getTaskByName(@RequestParam name: String, model: Model): String {

        model.addAttribute("chosenTasks", taskMapper.getByName(name))
        println(name)

        return "index"
    }


    @PostMapping("/updateTask")
    @ResponseBody
    fun updateTask(@RequestParam taskID: Int, @RequestParam complete: Boolean): String {
        println("Task updated successfully")
        taskMapper.update(taskID = taskID, complete = complete)

        return "redirect:/"
    }

    @PostMapping("/removeTask")
    fun removeTask(@RequestParam("removeBtn") removeBtn: Int): String{
        taskMapper.delete(removeBtn)
        println("Task Removed")
        return "redirect:/"
        }

}


@Controller
class RedirectController {

    private val info = mutableListOf<Task>()
    @PostMapping("/redirect")
    fun redirectToAnotherPage(): String {

        return "redirect:/secondary"
    }

}

