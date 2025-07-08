package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/v1")
class CommonController {

    @GetMapping("/error404")
    fun error404():String{
        return "common/error404"
    }

    @GetMapping("/error500")
    fun error500():String {
        return "common/error500"
    }
}