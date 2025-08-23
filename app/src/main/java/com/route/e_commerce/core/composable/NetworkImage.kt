package com.route.e_commerce.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.route.e_commerce.R
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    imageData: String?,
    contentScale: ContentScale = ContentScale.Crop
) {
    val context = LocalContext.current
    val shimmer = rememberShimmer(ShimmerBounds.View)
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageData)
            .crossfade(true)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .build(),
        contentDescription = null,
        contentScale = contentScale,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
                    .shimmer(shimmer)
                    .background(Color.LightGray)
            )
        },
        modifier = modifier
    )
}