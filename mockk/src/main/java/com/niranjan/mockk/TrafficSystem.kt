package com.niranjan.mockk

class TrafficSystem {

    fun signal(color: String) = when(color){
        "Red" -> "Stop"
        "Green" -> "Go"
        "Yellow" -> "Ready"
        else -> "Nothing"
    }
}