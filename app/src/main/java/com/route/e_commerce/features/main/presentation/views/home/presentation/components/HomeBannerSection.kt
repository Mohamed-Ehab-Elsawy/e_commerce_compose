package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.WormIndicatorType

@Composable
fun HomeBannerSection(modifier: Modifier = Modifier) {
    val banners = listOf(
        R.drawable.img_headphones_offer_banner,
        R.drawable.img_laptops_offer_banner,
        R.drawable.img_makeup_offer_banner,
    )
    val pagerState = rememberPagerState(
        pageCount = { banners.size }
    )
    Box(modifier) {
        HorizontalPager(state = pagerState, key = { banners[it] }) {
            BannerItem(banner = banners[it])
        }
        DotsIndicator(
            dotCount = banners.size,
            pagerState = pagerState,
            type = WormIndicatorType(
                dotsGraphic = DotGraphic(
                    8.dp,
                    color = white,
                ),
                wormDotGraphic = DotGraphic(
                    8.dp,
                    color = primaryLight,
                )
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
        )
    }

}

@Composable
fun BannerItem(
    modifier: Modifier = Modifier,
    @DrawableRes banner: Int
) {
    Image(
        painter = painterResource(id = banner),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
    )
}