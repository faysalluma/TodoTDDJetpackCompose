package com.groupec.todotddjetpackcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TodoListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel = TodoViewModel(TaskRepositoryImpl())

    @Before
    fun setUp() {
        composeTestRule.setContent { TodoList(viewModel) }
        composeTestRule.waitForIdle()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testScreenTitleIsShown() {
        composeTestRule.onNodeWithText("TODOs").assertIsDisplayed()
    }

    @Test
    fun testTaskItemsAreShown() {
        composeTestRule.onNodeWithText("Hello TDD").assertIsDisplayed()
        composeTestRule.onNodeWithText("This is fun").assertIsDisplayed()
        composeTestRule.onNodeWithText("I can not live without TDD").assertIsDisplayed()
    }
}