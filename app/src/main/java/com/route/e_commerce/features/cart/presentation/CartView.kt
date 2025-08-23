package com.route.e_commerce.features.cart.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.features.cart.presentation.components.CartViewBody
import com.route.e_commerce.features.cart.presentation.components.CartViewTopBar

@Composable
fun CartView(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CartViewTopBar(
                onBackClick = { navController.popBackStack() },
                onSearchClick = { navController.navigate(ECommerceRoutes.Search.route) }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        CartViewBody(
            modifier = Modifier.padding(paddingValues),
        )
    }
}