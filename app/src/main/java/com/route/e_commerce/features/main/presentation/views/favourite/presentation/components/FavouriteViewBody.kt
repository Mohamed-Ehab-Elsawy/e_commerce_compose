package com.route.e_commerce.features.main.presentation.views.favourite.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.core.composable.search_and_cart_section.SearchAndCartSection
import com.route.e_commerce.core.navigation.ECommerceRoutes

@Composable
fun FavouriteViewBody(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column {
        SearchAndCartSection(
            onCartClick = { navController.navigate(ECommerceRoutes.Cart.route) }
        )
    }
}