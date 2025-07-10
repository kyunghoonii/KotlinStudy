package com.example.demo.mapper

import com.example.demo.model.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun findAllUser(): List<User>
}