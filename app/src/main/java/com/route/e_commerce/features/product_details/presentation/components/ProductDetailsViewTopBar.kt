package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.BackIconButton
import com.route.e_commerce.core.composable.search_and_cart_section.CartIcon
import com.route.e_commerce.core.composable.search_and_cart_section.SearchIcon
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.core.utils.ECommerceTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsViewTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onCartClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = { BackIconButton(onClick = onBackClick) },
        title = {
            Text(
                text = stringResource(R.string.product_details),
                style = ECommerceTextStyles.text18.copy(
                    color = primaryLight
                ),
            )
        },
        actions = {
            IconButton(onClick = onSearchClick) {
                SearchIcon(
                    modifier = Modifier.size(24.dp)
                )
            }
            CartIcon(onClick = onCartClick)
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = white),
        modifier = modifier
    )
}