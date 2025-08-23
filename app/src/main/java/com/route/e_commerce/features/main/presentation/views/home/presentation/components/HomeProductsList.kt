package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.product_item.ProductItem
import com.route.e_commerce.core.data.entities.ProductEntity

@Composable
fun HomeProductsList(
    modifier: Modifier = Modifier,
    products: List<ProductEntity>,
    onItemClick: (ProductEntity) -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    LazyRow {
        items(products.size)
        {
            ProductItem(
                product = products[it],
                modifier = modifier
                    .width(screenWidth * 0.42f)
                    .clickable { onItemClick.invoke(products[it]) }
            )
        }

    }
}