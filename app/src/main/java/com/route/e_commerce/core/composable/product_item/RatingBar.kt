package com.route.e_commerce.core.composable.product_item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    productRating: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            stringResource(R.string.review),
            style = ECommerceTextStyles.text14.copy(color = primaryLight)
        )
        Text(
            text = productRating,
            style = ECommerceTextStyles.text14.copy(color = primaryLight)
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.ic_star),
            contentDescription = null,
            tint = Color(0xFFFDD835)
        )
    }
}