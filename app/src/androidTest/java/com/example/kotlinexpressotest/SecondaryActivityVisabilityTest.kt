package com.example.kotlinexpressotest
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4ClassRunner::class)

class SecondaryActivityVisabilityTest
{
    @get: Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun isActivityInView(){
        onView(withId(R.id.Secondary)).check(matches(isDisplayed()))
    }
    @Test
    fun isButtonDisplayed(){
        onView(withId(R.id.btn_nav_back)).check(matches(isDisplayed()))
    }
    @Test
    fun isTextDisplayed(){
        onView(withId(R.id.secondary_welcome)).check(matches(isDisplayed()))
    }
    @Test
    fun avatarImageDisplayed(){
        onView(withId(R.id.avatarImage)).check(matches(isDisplayed()))
    }
    @Test
    fun ageTextDisplayed(){
        onView(withId(R.id.textViewAge)).check(matches(isDisplayed()))
    }
    @Test
    fun nameDisplayed(){
        onView(withId(R.id.textViewName)).check(matches(isDisplayed()))
    }
}