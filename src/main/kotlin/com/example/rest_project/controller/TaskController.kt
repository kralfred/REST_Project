package com.example.rest_project.controller

import com.example.rest_project.entity.Task
import com.example.rest_project.repository.TaskMapper
import com.example.rest_project.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDate
import java.util.*



@Controller
class TaskController(
    private val taskMapper: TaskService
){

    private var chosenTasks: MutableList<Task> = mutableListOf()

    @GetMapping("/")
    fun showTasks(model: Model): String {
        model.addAttribute("tasks", taskMapper.getAll())
        model.addAttribute("chosenTasks", chosenTasks)

        return "index"
    }

    @PostMapping("/getTaskByName")
    fun getTaskByName(@RequestParam name: String, model: Model): String {
        chosenTasks = taskMapper.getByName(name).toMutableList()

        model.addAttribute("chosenTasks", chosenTasks)
        model.addAttribute("tasks", taskMapper.getAll())
        println(name)

        return "index"
    }


    @PostMapping("/addTask")
    fun addTask(@RequestParam name: String): String {
        println("Task added")

        val taskInstance = Task( name = name , complete = false, LocalDate.now(), task_id = UUID.randomUUID())
        taskMapper.insert(taskInstance)

        return "redirect:/"
    }




    @PostMapping("/updateTask")
    @ResponseBody
    fun updateTask(@RequestParam taskID: UUID, @RequestParam complete: Boolean): String {
        println("Task updated successfully")
        taskMapper.update(task_id = taskID, complete = complete)

        return "redirect:/"
    }

    @PostMapping("/removeTask")
    fun removeTask(@RequestParam("removeBtn") removeBtn: UUID): String{
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

