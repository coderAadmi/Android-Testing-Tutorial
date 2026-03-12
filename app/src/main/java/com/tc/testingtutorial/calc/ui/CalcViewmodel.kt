package com.tc.testingtutorial.calc.ui

import androidx.lifecycle.ViewModel
import com.tc.testingtutorial.calc.domain.AddUseCase

class CalcViewmodel constructor(private val addUseCase: AddUseCase): ViewModel() {
    fun add(a : Int, b : Int) = addUseCase(a,b)
}