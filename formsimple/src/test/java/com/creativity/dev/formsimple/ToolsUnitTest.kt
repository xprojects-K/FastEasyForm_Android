package com.creativity.dev.formsimple

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.runner.RunWith
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
class ToolsUnitTest {

    private lateinit var scenario: ActivityScenario<UnitTestActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(UnitTestActivity::class.java)
    }


    @Test
    fun test_init_isCorrect() {
        // Retrieve the activity instance from the scenario
        scenario.onActivity { activity ->

            val result = activity.init()

            // Perform assertions on the result
            Assert.assertEquals(true,result)
        }
    }

    @Test
    fun test_validateAll_isCorrect() {

        // Retrieve the activity instance from the scenario
        scenario.onActivity { activity ->

            val result = activity.validateAll()

            // Perform assertions on the result
            Assert.assertEquals(activity.success,result)
        }
    }

    @Test
    fun test_validateByTag_isCorrect() {

        // Retrieve the activity instance from the scenario
        scenario.onActivity { activity ->

            val result = activity.validateByTag()

            // Perform assertions on the result
            Assert.assertEquals(activity.success,result)
        }
    }
    @Test
    fun addition_isCorrect() {

        Assert.assertEquals(4, (2 + 2).toLong())

    }

    @After
    fun tearDown() {

        scenario.close()

    }

}