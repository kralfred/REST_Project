package com.example.rest_project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class RestProjectApplication


fun main(args: Array<String>) {
    runApplication<RestProjectApplication>(*args)
    println("started")

}

