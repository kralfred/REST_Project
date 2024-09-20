package com.example.rest_project.service

import com.example.rest_project.entity.User
import com.example.rest_project.repository.UserMapper
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService (
    private val encoder: PasswordEncoder,
    private val userMapper: UserMapper

){


    fun getAll(): List<User> = userMapper.getAll()
    fun getByName(name:String): List<User> =  userMapper.getByName(name)

    fun delete(userID: UUID) = userMapper.delete(userID)


    fun getByEmail(email:String): User = userMapper.getByEmail(email)?: throw UsernameNotFoundException("User not found")



//    fun changeFirstName(firstName: String, userID: UUID) = userMapper.changeFirstName(firstName, userID)
//    fun changeLastName(lastName: String, userID: UUID) = userMapper.changeLastName(lastName, userID)

}