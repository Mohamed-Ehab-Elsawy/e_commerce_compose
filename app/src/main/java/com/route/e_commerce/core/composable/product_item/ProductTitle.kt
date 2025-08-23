package com.route.e_commerce.core.composable.product_item

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun ProductTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        text = title,
        style = ECommerceTextStyles.text16.copy(
            color = primaryLight,
            fontWeight = FontWeight.SemiBold
        ),
        modifier = modifier.padding(
            start = 8.dp, end = 8.dp, bottom = 2.dp, top = 16.dp
        ), maxLines = 2, overflow = TextOverflow.Ellipsis
    )
}