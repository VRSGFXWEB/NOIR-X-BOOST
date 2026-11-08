package com.centralvex.noirxboost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.centralvex.noirxboost.ui.screens.ContactScreen
import com.centralvex.noirxboost.ui.screens.HomeScreen
import com.centralvex.noirxboost.ui.screens.SplashScreen
import com.centralvex.noirxboost.ui.theme.NoirXBoostTheme

/**
 * Entry point. TIDAK ADA halaman login / Google Sign-In di sini —
 * dari splash langsung ke Home sesuai permintaan.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoirXBoostTheme {
                AppRoot()
            }
        }
    }
}

private enum class Screen { SPLASH, HOME, CONTACT }

@Composable
private fun AppRoot() {
    var screen by remember { mutableStateOf(Screen.SPLASH) }

    when (screen) {
        Screen.SPLASH -> SplashScreen(onFinished = { screen = Screen.HOME })
        Screen.HOME -> HomeScreen(onOpenContact = { screen = Screen.CONTACT })
        Screen.CONTACT -> {
            BackHandler { screen = Screen.HOME }
            ContactScreen()
        }
    }
}
