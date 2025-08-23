package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.product_item.FavouriteIcon
import com.route.e_commerce.core.ui.theme.primaryLight

@Composable
fun ProductImagesSection(
    modifier: Modifier = Modifier,
    images: List<String?>,
    isFavourite: Boolean = false
) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    Box(
        modifier
            .fillMaxWidth()
            .border(
                1.dp,
                primaryLight.copy(alpha = 0.5f),
                RoundedCornerShape(16.dp)
            )
    ) {
        ImagesHorizontalPager(
            images = images,
            pagerState = pagerState
        )
        ImagesDotsIndicator(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            dotCount = images.size,
            pagerState = pagerState
        )
        FavouriteIcon(
            isFavourite = isFavourite,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd)
        )
    }
}