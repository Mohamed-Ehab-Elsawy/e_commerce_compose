package com.route.e_commerce.core.composable.product_item

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun PriceText(
    modifier: Modifier = Modifier,
    productPrice: String,
    textStyle: TextStyle = ECommerceTextStyles.text16.copy(primaryLight)
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = productPrice,
            style = textStyle
        )
        Text(
            text = stringResource(R.string.egp),
            style = textStyle
        )
    }
}