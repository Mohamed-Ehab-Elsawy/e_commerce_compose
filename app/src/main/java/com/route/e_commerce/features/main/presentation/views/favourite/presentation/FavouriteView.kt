package com.route.e_commerce.features.main.presentation.views.favourite.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.features.main.presentation.views.favourite.presentation.components.FavouriteViewBody

@Composable
fun FavouriteView(
    modifier: Modifier = Modifier, navController: NavController
) {
    FavouriteViewBody(
        modifier = modifier, navController = navController
    )
}