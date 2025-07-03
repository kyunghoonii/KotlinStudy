package com.example.demo.controller

import com.example.demo.entity.UserInfo
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.awt.PageAttributes

@RestController
@RequestMapping("/api/v1")
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class UserController {
    public val userMap: MutableMap<String, UserInfo> = mutableMapOf()
    
    @PostConstruct
    fun init(){
        userMap["1"] = UserInfo("1", "임리프", "111-1111", "광주")
        userMap["2"] = UserInfo("2", "리프", "222-2222", "서울")
        userMap["3"] = UserInfo("3", "임태", "333-3333", "판교")
    }

    @GetMapping(value=["/user/{id}"])
    fun getUserInfo(@PathVariable id: String ) = userMap[id]

    @GetMapping(value=["/user/all"])
    fun getUserAll() = ArrayList<UserInfo>(userMap.values)

    @GetMapping(value=["/user/add/{id}"])
    fun addUser(@PathVariable id:String, @RequestParam("name") name:String, @RequestParam("phone") phone: String, @RequestParam("address") address: String ): ArrayList<UserInfo> {
        userMap[id] = UserInfo(id=id, name=name, phone=phone, address=address)
        return ArrayList<UserInfo>(userMap.values)
    }

    @PostMapping(value=["/user/add"])
    fun addUserPost(@RequestBody user: UserInfo): ArrayList<UserInfo> {
        userMap[user.id] = user
        return ArrayList<UserInfo>(userMap.values)
    }

    @GetMapping(value=["/user/del/{id}"])
    fun delUser(@PathVariable id:String): ArrayList<UserInfo>{
        userMap.remove(id)
        return ArrayList<UserInfo>(userMap.values)
    }
}