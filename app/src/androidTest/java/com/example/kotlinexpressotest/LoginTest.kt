package com.example.kotlinexpressotest

import android.text.method.TextKeyListener.clear
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4ClassRunner::class)

class LoginTest {

// login screen
    object Login
{
        fun enterUsername(username : String){
            TestLoginComponent().enterUsername(username)
        }
        fun enterPassword(password: String){
            TestLoginComponent().enterPassword(password)
        }
        fun clickLogin(success: Boolean){
            TestLoginComponent().clickLoginButton(success)
        }
        fun navigateToSecondaryActivity(){
            TestLoginComponent().clickSecondaryActivity()
        }
    }

    class TestLoginComponent()
    {
        private val usernameEditField = R.id.username_edit_field
        fun enterUsername(username: String) {
            onView(withId(usernameEditField)).perform(clearText(),typeText(username), closeSoftKeyboard())
        }

        private val passwordEditField = R.id.password_edit_field
        fun enterPassword(password: String) {
            onView(withId(passwordEditField)).perform(clearText(),typeText(password), closeSoftKeyboard())
        }

        private val loginButtonId = R.id.login_button
        private val mainActivity = R.id.Main
        private val secondaryActivity = R.id.Secondary
        fun clickLoginButton(success: Boolean){
            onView(withId(loginButtonId)).perform(click())
            when(success){
                true -> onView(withId(secondaryActivity)).check(matches(isDisplayed()))
                false -> onView(withId(mainActivity)).check(matches(isDisplayed()))
            }
        }

        private val BtnNavSecondaryActivity = R.id.btn_nav_secondary
        fun  clickSecondaryActivity(){
            onView(withId(BtnNavSecondaryActivity )).perform(click())
            onView(withId(secondaryActivity)).check(matches(isDisplayed()))
        }
    }


    class TestCases() {
        @get: Rule
        val activityRule = ActivityScenarioRule(MainActivity::class.java)
        @Test
        fun loginToApp() {
            Login.enterUsername("Justin")
            Login.enterPassword("123456789")
            Login.clickLogin(true)
            Login.navigateToSecondaryActivity()
        }

    }
}