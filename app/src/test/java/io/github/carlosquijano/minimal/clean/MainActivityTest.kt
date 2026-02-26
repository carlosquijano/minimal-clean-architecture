package io.github.carlosquijano.minimal.clean

import android.os.Build
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.carlosquijano.minimal.clean.data.di.dataModule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setupKoin() {
        stopKoin()
        startKoin {
            modules(dataModule)
        }
    }

    @After
    fun tearDownKoin() {
        stopKoin()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.M])
    fun `test low API level with light theme`() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.M], qualifiers = "night")
    fun `test low API level with dark theme`() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S])
    fun `test high API level with light theme`() {
        assertTextNodeExists()
    }

    @Test
    @Config(sdk = [Build.VERSION_CODES.S], qualifiers = "night")
    fun `test high API level with dark theme`() {
        assertTextNodeExists()
    }

    private fun assertTextNodeExists(text: String = "Hello world!") {
        composeTestRule.onNodeWithText(text).assertExists()
    }
}