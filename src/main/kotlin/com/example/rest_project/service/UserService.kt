package com.example.rest_project.service

import com.example.rest_project.entity.User
import com.example.rest_project.repository.UserMapper
import java.util.*

class UserService (
    private val userMapper: UserMapper
){
    fun getAll(): List<User> = userMapper.getAll()
    fun getByName(name:String): List<User> =  userMapper.getByName(name)
    fun changeFirstName(userID: UUID, firstName: String) = userMapper.changeFirstName(userID, firstName)
    fun changeLastName(userID: UUID, lastName: String) = userMapper.changeLastName(userID, lastName)
    fun delete(userID: UUID) = userMapper.delete(userID)

}