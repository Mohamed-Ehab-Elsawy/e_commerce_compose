package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.product_item.PriceText
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun TotalPriceText(
    modifier: Modifier = Modifier,
    totalPrice: Double
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Text(
            text = stringResource(R.string.total_price),
            style = ECommerceTextStyles.text16.copy(primaryLight.copy(alpha = 0.8f))
        )
        Spacer(Modifier.height(4.dp))
        PriceText(
            productPrice = totalPrice.toString(),
            textStyle = ECommerceTextStyles.text18.copy(primaryLight)
        )
    }
}