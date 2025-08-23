package com.route.e_commerce.core.composable.search_and_cart_section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchAndCartSection(
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchTextField(modifier.weight(0.9f))
        CartIcon(modifier.weight(0.1f), onCartClick)
    }
}