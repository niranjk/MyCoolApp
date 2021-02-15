package com.niranjan.mockk

import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CarTest{

    // Annotations
    @MockK
    lateinit var car1: Car

    @RelaxedMockK
    lateinit var car2: Car

    @MockK(relaxUnitFun = true)
    lateinit var car3: Car

    @SpyK
    var car4 = Car()

    @InjectMockKs
    var trafficSystem = TrafficSystem()

    @Before
    fun setUp() = MockKAnnotations.init(this)


    @Test
    fun `given direction and speed when driven a car then test it's speed`(){
        //given
        //create a mock/spy
        val car = mockk<Car>(relaxed = true)

        // stub calls
        every { car.drives(Direction.NORTH) } returns "Driving North!"

        //execute code to test
        car.drives(Direction.NORTH)

        //verify
        verify { car.drives(Direction.NORTH) }
    }

    @Test
    fun `given direction test drive method using spy`(){
        //create a spy
        val car = spyk(Car())

        // when
        // car.drives(Direction.NORTH)

        // then

        car.drives(Direction.NORTH)
        car.drives(Direction.EAST)
        car.drives(Direction.SOUTH,speed = 40)
        verify {
            car.drives(Direction.NORTH)
            car.drives(Direction.EAST)
            car.drives(Direction.SOUTH,speed = 40)
        }

        //verify in sequence order
        car.drives(Direction.NORTH)
        car.drives(Direction.EAST)
        /*
        verifySequence {
            car.drives(Direction.NORTH)
            car.drives(Direction.EAST)
        }

         */

        // verify times
        car.drives(Direction.SOUTH)
        verify(atLeast = 1) { car.drives(any()) }
        verify(atMost = 5) { car.drives(any()) }
        verify(exactly = 5) { car.drives(any()) }
        verify(timeout = 1000L) { car.drives(any()) }

        // exclude calls
        excludeRecords { car.drives(Direction.SOUTH) }

        // combine matcher expressions
        every {
            car.drives(
                direction = or(Direction.SOUTH, Direction.EAST),
                speed = range(10L, 150L, fromInclusive = true, toInclusive = true)
            )
        } returns "Driving!!"
    }

    @Test
    fun `capturing Arguments Test`(){
        val car = mockk<Car>()
        val list = mutableListOf<Long>()

        every { car.drives(any(), capture(list)) } returns "Driving.."

        car.drives(Direction.EAST, 55)
        car.drives(Direction.SOUTH, 80)
        // Assert.assertTrue(list.containsAll(listOf(55L,60L)))
    }

    @Test
    fun `mock Constructor`(){
        // mock
        mockkConstructor(Car::class)

        every { anyConstructed<Car>().drives(any()) } returns "Driving!"

        Car().drives(Direction.EAST)

        verify { anyConstructed<Car>().drives(Direction.EAST) }

    }

    @Test
    fun `private function test`(){
        // mock
        val car = spyk<Car>(recordPrivateCalls = true)
        // between square bracket specify the method of private function to mock it
        every { car["accelerate"]() } returns "going not so fast"

        car.drives(Direction.EAST)

        verifySequence {
            // car["accelerate"]()
            car.drives(Direction.EAST)
        }

        // mocking property
        // every { car getProperty "speed" } returns 22
        // every { car setProperty "accelerate"  value less(5) } just Runs
        // every { car invokeNoArgs "accelerate" } returns "going slowly"
        // every { car invoke "accelerate" withArguments listOf("foo", "bar") } returns "going slowly"

    }

    @Test
    fun `coroutine mock test`(){
        val car = mockk<Car>()
        coEvery { car.drives(Direction.EAST) } returns "Driving East"
        car.drives(Direction.EAST)
        coVerify { car.drives(Direction.EAST) }
    }


}