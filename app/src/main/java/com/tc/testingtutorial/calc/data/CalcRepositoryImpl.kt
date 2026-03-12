package com.tc.testingtutorial.calc.data

import com.tc.testingtutorial.calc.domain.CalcRepository

class CalcRepositoryImpl : CalcRepository {
    override fun add(a: Int, b: Int): Int {
        return 1
    }
}