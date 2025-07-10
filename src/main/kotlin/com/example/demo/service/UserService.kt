package com.example.demo.service

import com.example.demo.mapper.UserMapper
import com.example.demo.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMapper: UserMapper
) {
    fun findAllUser():List<User> {
        val users = userMapper.findAllUser()
        return users
    }
}