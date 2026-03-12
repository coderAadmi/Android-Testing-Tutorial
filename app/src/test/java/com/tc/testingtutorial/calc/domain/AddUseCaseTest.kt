package com.tc.testingtutorial.calc.domain

import com.google.common.truth.Truth.assertThat
import com.tc.testingtutorial.calc.data.CalcRepositoryImpl
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.math.exp

class AddUseCaseTest {

    /**
     * AAA in testing
     * Arrange -> setup everything required for the test
     * Act -> invoke the function under test
     * Assert -> assert the expectations
     */

    private lateinit var addUseCase: AddUseCase
    private val calcRepository = CalcRepositoryImpl()

    @Before
    fun setUp() {
        addUseCase = AddUseCase(calcRepository)
    }

    @Test
    fun `Test when a = 0 and b = -100`(){
        assertEquals( -100, addUseCase(a = 0, b = -100) )
    }

    @Test
    fun `Test with a = Integer Max and b = 1`(){
        val expected : UInt = Int.MAX_VALUE.toUInt() + 1.toUInt()
        assertEquals(expected, addUseCase(a = Int.MAX_VALUE, b = 1) )
    }

    @Test
    fun `Test when a = 50 and b = -50`(){
        assertThat(addUseCase(50,-50)).isEqualTo(5)
    }


    @After
    fun tearDown() {

    }

}

//4 bytes -> 32 bits
//        1 bit -> polarity
//        total bits used to represent an int = 31
//        2^31