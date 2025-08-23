package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R

@Composable
fun ShoesOfferBanner(modifier: Modifier = Modifier) {
    BannerItem(
        modifier = modifier.padding(vertical = 24.dp),
        banner = R.drawable.img_shoes_offer_banner
    )
}