package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddToCartSection(
    modifier: Modifier = Modifier, totalPrice: Double, onAddToCartClick: () -> Unit
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TotalPriceText(totalPrice = totalPrice)
        Spacer(Modifier.width(32.dp))
        AddToCartButton(
            modifier = Modifier.weight(1f),
            onAddToCartClick = onAddToCartClick
        )
    }
}