package com.example.kotlinexpressotest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.Test


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityVisabilityTest{


    @Test
    fun isActivityInView(){
        //Launch an activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.Main)).check(matches(isDisplayed()))
    }

    @Test
    fun isButtonVisable(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btn_nav_secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun inputVisable(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.username_edit_field)).check(matches(isDisplayed()))
    }
    @Test
    fun enterUserNameForGreeting(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.username_edit_field)).perform(typeText("Justin"))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.greeting)).check(matches(withText("Hello Justin!")))
    }

    @Test
    fun isWelcomeTextVisable(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.welcomText)).check(matches(isDisplayed()))

    }
    @Test
    fun isWelcomeTextCorrect(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.welcomText)).check(matches(withText("Welcome")))
    }
    @Test
    fun navigateToSecondaryActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btn_nav_secondary)).perform(click())
        onView(withId(R.id.Secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun backNavigationAfterOpeningSecondaryActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btn_nav_secondary)).perform(click())
        onView(withId(R.id.btn_nav_back)).perform(click())
        onView(withId(R.id.Main)).check(matches(isDisplayed()))
    }

}