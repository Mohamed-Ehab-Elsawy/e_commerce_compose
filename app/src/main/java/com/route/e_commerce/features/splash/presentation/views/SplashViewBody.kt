package com.route.e_commerce.features.splash.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.transparent
import com.route.e_commerce.core.ui.theme.white

@Composable
fun SplashViewBody(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.TopCenter)
                .background(
                    brush = splashRadialGradientBrush(y = 0f)
                )
        )

        Image(
            painter = painterResource(id = R.drawable.route_logo),
            contentDescription = "Splash logo",
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .wrapContentHeight()
                .align(Alignment.Center),
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = splashRadialGradientBrush(y = 1000f)
                )
        )
    }
}

private fun splashRadialGradientBrush(y: Float): Brush =
    Brush.radialGradient(
        colors = listOf(white.copy(alpha = 0.5f), transparent),
        center = Offset(x = 500f, y = y),
        radius = 800f
    )