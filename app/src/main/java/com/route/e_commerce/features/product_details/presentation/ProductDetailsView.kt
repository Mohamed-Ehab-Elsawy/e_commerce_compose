package com.route.e_commerce.features.product_details.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.features.product_details.presentation.components.ProductDetailsViewBody
import com.route.e_commerce.features.product_details.presentation.components.ProductDetailsViewTopBar

@Composable
fun ProductDetailsView(
    modifier: Modifier = Modifier,
    navController: NavController,
    product: ProductEntity
) {
    Scaffold(
        topBar = {
            ProductDetailsViewTopBar(
                onBackClick = { navController.popBackStack() },
                onCartClick = {
                    navController.navigate(ECommerceRoutes.Cart.route)
                },
                onSearchClick = {
                    navController.navigate(ECommerceRoutes.Search.route)
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        ProductDetailsViewBody(
            modifier = Modifier.padding(paddingValues),
            product = product
        )
    }
}