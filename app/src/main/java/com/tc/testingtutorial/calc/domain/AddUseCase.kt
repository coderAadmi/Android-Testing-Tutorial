package com.tc.testingtutorial.calc.domain

class AddUseCase constructor(private  val repository: CalcRepository) {
    operator suspend fun invoke(a:  Int, b : Int) = repository.add(a,b)
}