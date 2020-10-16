package com.example.kotlinexpressotest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4ClassRunner::class)

class LoginTest {

// login screen
    object Login{
        fun enterUsername(username : String){
            TestUsername().enterUsername(username)
        }
        fun enterPassword(password: String){
            TestPassword().enterPassword(password)
        }
    fun submitLoginInfo(){
        TestLoginButton().clickLoginButton()
    }

    }
    class TestUsername(){
        val usernameEditField = R.id.username_edit_field
        fun enterUsername(username: String){
            onView(withId(usernameEditField)).perform(typeText(username))
        }
    }
    class TestPassword( ){
        val passwordEditField = R.id.password_edit_field
        fun enterPassword(password: String){
            onView(withId(passwordEditField)).perform(typeText(password))
        }
    }

    class  TestLoginButton(){
        val loginButtonId = R.id.login_button
        fun clickLoginButton(){
            onView(withId(loginButtonId)).perform(click())
        }
    }


    class TestCases() {
        @Test
        fun initActivityScenario(){
            val activityScenario = ActivityScenario.launch(MainActivity::class.java)
            loginEntery()
        }
        fun loginEntery() {
            Login.enterUsername("Justin")
            Login.enterPassword("123456789")
            Login.submitLoginInfo()
        }

    }
}