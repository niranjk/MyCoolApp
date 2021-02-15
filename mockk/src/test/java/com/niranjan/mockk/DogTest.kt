package com.niranjan.mockk

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class DogTest{

    @Test
    fun `given Dog when barks then test`(){
        // mock
        val dog = mockk<Dog>()

        every { dog.barks() } returns "Bow! Bow!"

        dog.barks()

        verify { dog.barks() } // if you comment this line the test will fail
        confirmVerified(dog)
    }
}