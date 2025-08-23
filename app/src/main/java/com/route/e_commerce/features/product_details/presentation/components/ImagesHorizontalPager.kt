package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.NetworkImage

@Composable
fun ImagesHorizontalPager(
    modifier: Modifier = Modifier,
    images: List<String?>,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
    ) {
        NetworkImage(
            imageData = images[it],
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .height(300.dp)
        )
    }
}