package com.centralvex.noirxboost.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.centralvex.noirxboost.ui.theme.NoirBackgroundGradient
import com.centralvex.noirxboost.ui.theme.NoirCrimsonSoft
import com.centralvex.noirxboost.ui.theme.NoirGoldAccent
import com.centralvex.noirxboost.ui.theme.NoirTextMuted
import com.centralvex.noirxboost.ui.theme.NoirTextPrimary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    val scale = remember { Animatable(0.6f) }
    val alpha = remember { Animatable(0f) }
    var showTagline by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, tween(600, easing = FastOutSlowInEasing))
        scale.animateTo(1f, tween(700, easing = FastOutSlowInEasing))
        showTagline = true
        delay(900)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NoirBackgroundGradient),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .scale(scale.value)
                    .clip(CircleShape)
                    .background(NoirCrimsonSoft.copy(alpha = alpha.value * 0.9f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "N",
                    color = NoirTextPrimary,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "NOIR x BOOST",
                color = NoirTextPrimary,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 4.sp,
                modifier = Modifier
                    .padding(top = 18.dp)
                    .scale(scale.value)
            )

            if (showTagline) {
                Text(
                    text = "by CENTRALVEX",
                    color = NoirGoldAccent,
                    fontSize = 13.sp,
                    letterSpacing = 2.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Text(
            text = "Performance, refined.",
            color = NoirTextMuted,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp)
        )
    }
}
