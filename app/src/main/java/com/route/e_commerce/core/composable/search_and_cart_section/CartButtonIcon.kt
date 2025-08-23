package com.route.e_commerce.core.composable.search_and_cart_section

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight

@Composable
fun CartIcon(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(R.drawable.icon_shopping_cart),
            contentDescription = stringResource(R.string.cart),
            tint = primaryLight,
            modifier = modifier.size(24.dp)
        )
    }
}