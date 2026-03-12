package com.tc.testingtutorial.calc.domain

interface CalcRepository {
    fun add(a : Int, b : Int) : Int
}