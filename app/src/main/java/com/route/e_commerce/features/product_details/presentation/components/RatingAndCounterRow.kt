package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.route.e_commerce.core.composable.QuantityStepper
import com.route.e_commerce.core.composable.product_item.RatingBar

@Composable
fun RatingAndCounterRow(
    modifier: Modifier = Modifier,
    rating: Double,
    sold: Int,
    onValueChange: (Int) -> Unit,
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SoldText(sold = sold)
        RatingBar(productRating = rating.toString())
        QuantityStepper(
            onValueChange = onValueChange
        )
    }
}