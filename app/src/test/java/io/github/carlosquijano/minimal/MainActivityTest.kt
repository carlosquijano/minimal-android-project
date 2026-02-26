package io.github.carlosquijano.minimal

import android.os.Build
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

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