package com.niranjan.mycoolapp.kotlintut

import org.junit.Assert.*
import org.junit.Test

//
// Created by NIRANJAN KHATRI on 18/01/2021.
// Copyright (c) 2021 NIRANJAN KHATRI. All rights reserved.
//
class PrivateClassTest{

    @Test
    fun `given Number when You Square The Number then Return Result Of Square`(){
        // Given
        val squareObj = PrivateClass()
        // Perform a task : doing a square of a value
        val given = squareObj.square(2)
        // Expected result is 4
        val expected = 4
        assertEquals(expected, given)
    }
}