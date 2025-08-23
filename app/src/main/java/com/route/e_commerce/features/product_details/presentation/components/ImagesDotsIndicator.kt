package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.transparent
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.WormIndicatorType

@Composable
fun ImagesDotsIndicator(
    modifier: Modifier = Modifier,
    dotCount: Int,
    pagerState: PagerState
) {
    DotsIndicator(
        dotCount = dotCount,
        type = WormIndicatorType(
            dotsGraphic = DotGraphic(
                8.dp,
                borderWidth = 1.dp,
                borderColor = primaryLight,
                color = transparent
            ),
            wormDotGraphic = DotGraphic(
                7.dp,
                color = primaryLight
            )
        ),
        pagerState = pagerState,
        modifier = modifier
    )
}