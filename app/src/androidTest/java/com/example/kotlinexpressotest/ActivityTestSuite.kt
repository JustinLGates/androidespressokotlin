package com.example.kotlinexpressotest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        LoginTest::class,
    MainActivityVisabilityTest::class ,
    SecondaryActivityVisabilityTest::class
)
class ActivityTestSuite{

}