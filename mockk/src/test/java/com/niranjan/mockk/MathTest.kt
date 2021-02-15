package com.niranjan.mockk

import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.*
import org.junit.Test

class MathTest{

    @Test
    fun `given two number when add funciton call then test the result`(){
        // mock the object
        val mockObj = mockkObject(Math)

        //when
        every { Math.add(1,2) } returns 4
        assertEquals(4, Math.add(1,2))
    }
}