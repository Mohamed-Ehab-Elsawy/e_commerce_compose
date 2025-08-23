package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.product_item.PriceText
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun TitleAndPriceRow(
    modifier: Modifier = Modifier,
    title: String,
    price: Double
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = ECommerceTextStyles.text18.copy(primaryLight),
            modifier = Modifier.weight(0.65f)
        )
        PriceText(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 12.dp,
                    top = 2.dp
                )
                .weight(0.28f),
            productPrice = price.toString(),
            textStyle = ECommerceTextStyles.text18.copy(primaryLight)
        )
    }
}