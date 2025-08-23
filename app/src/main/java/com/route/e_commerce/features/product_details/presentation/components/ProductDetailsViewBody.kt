package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.ui.theme.white

@Composable
fun ProductDetailsViewBody(
    modifier: Modifier = Modifier, product: ProductEntity
) {
    var totalPrice by remember { mutableDoubleStateOf(product.price) }
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .background(white)
    ) {
        item { ProductImagesSection(images = product.images) }
        item { Spacer(Modifier.height(16.dp)) }
        item { TitleAndPriceRow(title = product.title, price = product.price) }
        item { Spacer(Modifier.height(16.dp)) }
        item {
            RatingAndCounterRow(
                rating = product.rating,
                sold = product.sold,
                onValueChange = {
                    totalPrice = product.price * it
                }
            )
        }
        item { Spacer(Modifier.height(8.dp)) }
        item { DescriptionSection(description = product.description) }
        item { Spacer(Modifier.height(32.dp)) }
        item {
            AddToCartSection(
                totalPrice = totalPrice,
                onAddToCartClick = {
                    //TODO
                }
            )
        }
    }
}