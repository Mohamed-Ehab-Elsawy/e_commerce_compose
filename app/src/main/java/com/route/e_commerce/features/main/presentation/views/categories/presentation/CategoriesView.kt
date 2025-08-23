package com.route.e_commerce.features.main.presentation.views.categories.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.features.main.presentation.views.categories.presentation.components.CategoriesViewBody

@Composable
fun CategoriesView(
    modifier: Modifier = Modifier, navController: NavController
) {
    CategoriesViewBody(
        modifier = modifier, navController = navController
    )
}