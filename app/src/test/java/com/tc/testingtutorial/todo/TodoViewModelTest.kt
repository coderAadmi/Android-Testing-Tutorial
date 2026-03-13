package com.tc.testingtutorial.todo

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {

    val apiMock = mockk<TodoApi>()
    private lateinit var todoViewModel: TodoViewModel

    @Before
    fun setUp() {
        //every { car.drive(Direction.NORTH) } returns Outcome.OK
        coEvery { apiMock.getAll() } returns listOf(
            Todo(1, 1, "T1", false),
            Todo(2, 1, "T2", false),
            Todo(3, 2, "T3", false),
            Todo(4, 3, "T4", true)
        )

        todoViewModel = TodoViewModel(object : TodoRepository {

            override suspend fun getTodos(): List<Todo> {
                return apiMock.getAll()
            }
        }
        )
    }

    @Test
    fun `mock test for todo API`() {
        assertThat(todoViewModel.todos.value).isEmpty()
        todoViewModel.getTodos()
        runBlocking {
            todoViewModel.todos.collect { todos ->
                assertThat(todos).containsAnyIn(listOf(
                    Todo(1, 1, "T1", false),
                    Todo(2, 1, "T2", false),
                    Todo(3, 2, "T3", false),
                    Todo(4, 3, "T4", true)
                ))
            }
        }


    }

}