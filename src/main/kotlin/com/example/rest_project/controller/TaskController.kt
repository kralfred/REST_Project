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
    fun addTask(name: String): String {
        val taskInstance = Task(name=name)

        taskMapper.insert(taskInstance)

        println("Added")
        return "redirect:/"
    }



    // Docker desktop
    // mybattins

    @PostMapping("/updateTask")
    @ResponseBody
    fun updateTask(@RequestParam taskId: UUID, @RequestParam completed: Boolean): String {
//        val taskToUpdate = tasks.find { it.id == taskId }
//        taskToUpdate?.completed = completed
        println("Task updated successfully")
        return "redirect:/"
    }

    @PostMapping("/removeTask")
    fun removeTask(@RequestParam("removeBtn") removeBtn: UUID): String{
        //tasks.removeIf{ task -> task.id == removeBtn }
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

