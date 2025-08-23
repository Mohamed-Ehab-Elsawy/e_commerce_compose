package com.route.e_commerce.core.composable.search_and_cart_section

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight

@Composable
fun SearchIcon(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(R.drawable.icon_search),
        contentDescription = stringResource(R.string.search),
        tint = primaryLight,
        modifier = modifier
    )
}