package com.tc.testingtutorial.calc.ui

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.tc.testingtutorial.calc.data.CalcRepositoryImpl
import com.tc.testingtutorial.calc.domain.AddUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalcScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    val calcVm = CalcViewmodel(AddUseCase(CalcRepositoryImpl()))

    @Before
    fun setUp(){
        composeRule.setContent {
            CalcScreen(calcVm)
        }
    }

    @Test
    fun add_the_fields_button_is_visible(){
        composeRule.onNodeWithTag("add_Btn").isDisplayed()
    }

    @Test
    fun correct_result_is_showed() = runTest{
        composeRule.onNodeWithTag("FIELD_A").performTextClearance()
        composeRule.onNodeWithTag("FIELD_A")  .performTextInput("5")
        composeRule.onNodeWithTag("FIELD_B").performTextClearance()
        composeRule.onNodeWithTag("FIELD_B").performTextInput("6")
        composeRule.onNodeWithTag("add_Btn").performClick()
        composeRule.onNodeWithTag("RESULT_TAG").assertTextContains("11")
    }

}