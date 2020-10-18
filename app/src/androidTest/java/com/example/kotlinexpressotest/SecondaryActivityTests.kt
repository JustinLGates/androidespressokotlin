package com.example.kotlinexpressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTests {

    //All define all actions that can be taken on the screen
    object UserProfile{
        fun enterName(name:String){
            TestUserInfo().enterName(name)
        }
        fun enterAge(age:String){
            TestUserInfo().enterAge(age)
        }
        fun clickUpdateInfo(){
            TestUserInfo().clickUpdateButton()
        }
        fun clickBack(){
            TestUserInfo().clickBackButton()
        }

    }


    class TestUserInfo(){

        private val nameInput = R.id.EditTextName
        fun enterName(name:String){
            onView(withId(nameInput)).perform(ViewActions.clearText(),typeText(name), ViewActions.closeSoftKeyboard())
        }

        private val ageInput = R.id.EditTextAge
        fun enterAge(age:String){
            onView(withId(ageInput)).perform(ViewActions.clearText(),typeText(age), ViewActions.closeSoftKeyboard())
        }

        private val updateUserButton = R.id.updateUserInfoButton
        fun clickUpdateButton (){}

        private val backButton = R.id.btn_nav_back
        fun clickBackButton(){}
    }


    class  TestCases(){
        @get: Rule
        val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)
        @Test
        fun updateUserInfo(){
            UserProfile.enterName("Justin")
            UserProfile.enterAge("30")
            UserProfile.clickUpdateInfo()
        }
    }


}