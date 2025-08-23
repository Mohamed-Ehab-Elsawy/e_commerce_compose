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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun FavouriteIcon(
    modifier: Modifier = Modifier,
    isFavourite: Boolean
) {
    var isFavourite by remember { mutableStateOf(isFavourite) }

    val rotation by animateFloatAsState(
        targetValue = if (isFavourite) 180f else 0f,
        label = "flipAnimation"
    )

    Box(
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape)
            .background(white)
            .clickable { isFavourite = !isFavourite }
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12 * density
            },
        contentAlignment = Alignment.Center
    ) {
        if (rotation <= 90f) {
            Icon(
                painter = painterResource(R.drawable.ic_favourite),
                contentDescription = null,
                tint = primaryLight,
                modifier = Modifier.size(18.dp)
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.ic_fav_filled),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(18.dp)
                    .graphicsLayer { rotationY = 180f }
            )
        }
    }
}