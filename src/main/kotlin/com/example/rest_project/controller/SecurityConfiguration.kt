package com.example.rest_project.controller

import com.example.rest_project.security.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfiguration (
    authenticationProvider: AuthenticationProvider,
) {
    @Bean
    fun securityFilterChain(
        http: HttpSecurity, authenticationProvider: AuthenticationProvider,
        jwtAuthenticationFilter: JwtAuthenticationFilter,
    ): SecurityFilterChain = http.csrf{ it.disable() }.authorizeHttpRequests{
        it.requestMatchers("api/auth","/login","/register", "api/auth/refresh", "/error")
            .permitAll()
            .requestMatchers(HttpMethod.POST, "api/users", "/newuser", "/logincheck")
            .permitAll()
            .requestMatchers("/main")
            .authenticated()
            .requestMatchers("/api/user**")
            .hasRole("ADMIN")
            .anyRequest()
            .fullyAuthenticated()
              }.formLogin {
                  it.
                  loginPage("/login").
                          permitAll()

    }
        .sessionManagement {
                  it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        .build()

    }


