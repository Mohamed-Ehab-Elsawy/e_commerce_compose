package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier,
    onAddToCartClick: () -> Unit
) {
    ElevatedCard(
        onClick = onAddToCartClick,
        colors = CardDefaults.cardColors(containerColor = primaryLight),
        shape = RoundedCornerShape(24.dp),
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add_to_cart),
                contentDescription = stringResource(R.string.add_to_cart),
                tint = white,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = stringResource(R.string.add_to_cart),
                style = ECommerceTextStyles.text18
            )
        }
    }
}