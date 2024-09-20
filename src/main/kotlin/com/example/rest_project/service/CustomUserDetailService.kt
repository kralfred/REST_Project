package com.example.rest_project.service

import org.springframework.stereotype.Service
import com.example.rest_project.repository.UserMapper
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

typealias AplicationUser = com.example.rest_project.entity.User

@Service
class CustomUserDetailService(
    private val userMapper: UserMapper
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
        userMapper.getByEmail(username)?.mapToUserDetails()?: throw UsernameNotFoundException("User not found")

    private fun AplicationUser.mapToUserDetails(): UserDetails =
        User.builder().username(this.email).password(this.password).roles(this.role.name).build()


}

