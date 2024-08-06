package com.example.rest_project

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Repository

@SpringBootApplication
@MapperScan(basePackages = ["com.example.rest_project.repository"], annotationClass = Repository::class)
class RestProjectApplication


fun main(args: Array<String>) {
    runApplication<RestProjectApplication>(*args)
    println("started")

}

