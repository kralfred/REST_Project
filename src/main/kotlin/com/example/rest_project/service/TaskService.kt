package com.example.rest_project.service

import com.example.rest_project.entity.Task
import com.example.rest_project.repository.TaskMapper
import org.springframework.stereotype.Service
import java.util.*


@Service
class TaskService (
    private val taskMapper: TaskMapper
){
    fun getAll(): List<Task> = taskMapper.getAll()
    fun insert(task: Task) = taskMapper.insert(task)
    fun getByName(name:String): List<Task> =  taskMapper.getByName(name)
    fun update(task_id: UUID, complete: Boolean) = taskMapper.update(task_id, complete)
    fun delete(task_id: UUID) = taskMapper.delete(task_id)
}