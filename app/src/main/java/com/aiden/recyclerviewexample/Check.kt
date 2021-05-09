package com.aiden.recyclerviewexample


fun main() {


    val callMe = callMe("hello") {
        println(it)
    }

    println(callMe)
}

fun callMe(string: String, stringWrapper: (String) -> Unit): String {
    stringWrapper(string.toUpperCase())
    return string.reversed()
}