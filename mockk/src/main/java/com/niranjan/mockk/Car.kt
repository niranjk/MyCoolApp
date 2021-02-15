package com.niranjan.mockk


class Car {
    fun drives(direction: Direction, speed: Long = 30): String =
        "Driving $direction at $speed km/hr"

    private fun slow() = "Going Slow"
    private fun accelerate() = "Going Fast"
}

enum class Direction{
    EAST,
    WEST,
    NORTH,
    SOUTH
}
