package io.github.carlosquijano.clean

import android.os.Build
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import com.carlosquijano.clean.data.di.dataModule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest : BaseKoinTest() {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        stopKoin()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(ApplicationProvider.getApplicationContext())
            modules(dataModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.M])
    fun testLowApi_lightTheme() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.M], qualifiers = "night")
    fun testLowApi_darkTheme() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun testHighApi_lightTheme() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S], qualifiers = "night")
    fun testHighApi_darkTheme() {
        assertTextNodeExists()
    }

    private fun assertTextNodeExists(text: String = "Hello world!") {
        composeTestRule.onNodeWithText(text).assertExists()
    }
}