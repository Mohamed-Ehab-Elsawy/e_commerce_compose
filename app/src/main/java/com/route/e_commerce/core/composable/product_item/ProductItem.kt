package com.route.e_commerce.core.composable.product_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.NetworkImage
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductEntity
) {
    Card(
        colors = CardDefaults.outlinedCardColors(containerColor = white),
        border = BorderStroke(1.dp, primaryLight.copy(alpha = 0.7f)),
        elevation = CardDefaults.outlinedCardElevation(4.dp),
        modifier = modifier
            .padding(horizontal = 8.dp)
            .wrapContentHeight()
    ) {
        Box(Modifier.wrapContentSize()) {
            Column {
                NetworkImage(
                    imageData = product.imageCover,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
                ProductTitle(title = product.title)
                RatingBar(productRating = product.rating.toString())
                PriceText(
                    productPrice = product.price.toString(),
                    modifier = Modifier.padding(
                        start = 8.dp, end = 8.dp, bottom = 12.dp, top = 2.dp
                    )
                )
            }
            FavouriteIcon(
                isFavourite = product.inFavorite,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
            )
            AddToCartIconButton(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}