package com.niranjan.mockk

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

class AddressBookTest {

    @Test
    fun `given address book then test it`(){
        val addressBookMock = mockk<AddressBook> {
            every { contacts } returns listOf(
                mockk{
                    every { name } returns "Sam"
                    every { telephone } returns "3334567889"
                    every { address.city } returns "Milan"
                    every { address.zip } returns "20513"
                },
                mockk{
                    every { name } returns "Sunny"
                    every { telephone } returns "333456222"
                    every { address } returns mockk {
                        every { city } returns "Rome"
                        every { zip } returns "12304"
                    }
                }
            )
        }
    }
}