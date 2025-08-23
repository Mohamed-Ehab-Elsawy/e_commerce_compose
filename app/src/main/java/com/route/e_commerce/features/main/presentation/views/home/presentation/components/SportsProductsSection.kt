package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.data.entities.ProductEntity

@Composable
fun SportsProductsSection(
    modifier: Modifier = Modifier,
    products: List<ProductEntity>,
    onItemClick: (ProductEntity) -> Unit
) {
    HomeProductsSection(
        modifier = modifier,
        title = stringResource(R.string.sports_products),
        products = products,
        onItemClick = onItemClick
    )
}