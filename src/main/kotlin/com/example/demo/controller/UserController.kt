package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.service.UserService
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class UserController (
    private val userService: UserService
) {
    @GetMapping("/user/all")
    fun findAllUser(): List<User>{
        val users = userService.findAllUser()
        println(users)
        return users
    }
}