package com.route.e_commerce.core.composable.product_item

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun AddToCartIconButton(
    modifier: Modifier = Modifier
) {
    var isAdded by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isAdded) 180f else 0f,
        label = "flipAnimation"
    )

    Box(
        modifier = modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(primaryLight)
            .clickable { isAdded = !isAdded }
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12 * density
            },
        contentAlignment = Alignment.Center
    ) {
        if (rotation <= 90f) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = null,
                tint = white,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.ic_check),
                contentDescription = null,
                tint = white,
                modifier = Modifier
                    .size(24.dp)
                    .graphicsLayer { rotationY = 180f }
            )
        }
    }
}