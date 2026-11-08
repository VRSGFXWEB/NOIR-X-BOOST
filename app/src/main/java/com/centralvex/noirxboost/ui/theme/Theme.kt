package com.centralvex.noirxboost.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val NoirDarkScheme = darkColorScheme(
    primary = NoirCrimsonSoft,
    onPrimary = NoirTextPrimary,
    secondary = NoirGoldAccent,
    background = NoirBlack,
    onBackground = NoirTextPrimary,
    surface = NoirCharcoal,
    onSurface = NoirTextPrimary,
    error = NoirCrimson
)

/**
 * Gradasi utama background app — halus, tidak mencolok, dari charcoal ke crimson gelap.
 */
val NoirBackgroundGradient = Brush.verticalGradient(
    colors = listOf(NoirBlack, NoirCharcoal, NoirCrimsonDeep.copy(alpha = 0.55f), NoirBlack)
)

/**
 * Efek liquid glass untuk card/container: lapisan transparan tipis + border halus.
 */
val NoirGlassFill = Brush.linearGradient(
    colors = listOf(Color.White.copy(alpha = 0.08f), Color.White.copy(alpha = 0.02f))
)

@Composable
fun NoirXBoostTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NoirDarkScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}
