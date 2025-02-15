package com.example.testmobil2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    // 1. Тест нажатия на кнопку с проверкой изменения данных
    @Test
    fun testButtonClickChangesTextView() {
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.TextView)).check(matches(withText("Expected Text After Click")))
    }

    // 2. Проверка на вводимые данные
    @Test
    fun testInputText() {
        onView(withId(R.id.editTextText)).perform(typeText("Hello World"))

        onView(withId(R.id.editTextText)).check(matches(withText("Hello World")))

        onView(withId(R.id.editTextText)).perform(clearText())
        onView(withId(R.id.editTextText)).check(matches(withText("")))
    }

    // 3. Тест на переход между экранами (проверка второй активности)
    @Test
    fun testNavigationToSecondActivity() {
        onView(withId(R.id.button2)).perform(click())

        onView(withId(R.id.textView2)).check(matches(withText("Welcome to Second Activity")))
    }

    // 4. Проверка отображения элементов (например, проверка наличия текста в TextView)
    @Test
    fun testDisplayElements() {
        onView(withId(R.id.TextView)).check(matches(isDisplayed()))
        onView(withId(R.id.TextView)).check(matches(withText("Hello World!")))

        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.button2)).check(matches(isDisplayed()))
    }
}
