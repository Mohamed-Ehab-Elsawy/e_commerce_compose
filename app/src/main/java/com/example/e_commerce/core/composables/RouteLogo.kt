package com.example.e_commerce.core.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.e_commerce.R

@Composable
fun RouteLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.route_logo),
        contentDescription = stringResource(R.string.app_logo),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(0.8f)
    )
}