package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1")
class LoginController {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }
}