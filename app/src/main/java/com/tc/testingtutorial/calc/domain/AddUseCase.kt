package com.tc.testingtutorial.calc.domain

class AddUseCase constructor(private  val repository: CalcRepository) {
    operator fun invoke(a:  Int, b : Int) = repository.add(a,b)
}