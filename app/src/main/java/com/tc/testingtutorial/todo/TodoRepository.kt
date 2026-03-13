package com.tc.testingtutorial.todo

interface TodoRepository {
    suspend fun getTodos() : List<Todo>
}