package com.example.rest_project.security

import com.example.rest_project.repository.UserMapper
import com.example.rest_project.security.JwtProperties
import com.example.rest_project.service.CustomUserDetailService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableConfigurationProperties(JwtProperties::class)
class Configuration {

    @Bean
    fun userDetailService(userMapper: UserMapper): UserDetailsService = CustomUserDetailService(userMapper)

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()


    @Bean
    fun authenticationProvider(userMapper: UserMapper): AuthenticationProvider {
        return DaoAuthenticationProvider().also {
            it.setUserDetailsService(userDetailService(userMapper))
            it.setPasswordEncoder(encoder())
        }
    }


    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager = config.authenticationManager
}