package com.example.rest_project.service

import com.example.rest_project.entity.Role
import com.example.rest_project.entity.User
import com.example.rest_project.repository.RegisterMapper
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class RegisterService (
    private val registerMapper: RegisterMapper,
    private val encoder: PasswordEncoder,
){
    fun createUser(user: User): String{
        user.password = encoder.encode(user.password)
        println(user)

        registerMapper.createUser(user)
        return "created user"
    }


}