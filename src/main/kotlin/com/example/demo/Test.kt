package com.example.demo

class Test {

}

fun main(){
    val test: MutableMap<String, String> = mutableMapOf("1" to "CCC", "2" to "BBB", "3" to "AAA")
    val tt = test.keys.max()
    println(tt)

    test[(tt.toInt()+1).toString()] = "DDD"
    println(test)
}