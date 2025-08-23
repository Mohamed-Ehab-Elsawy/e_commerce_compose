package com.route.e_commerce.features.main.presentation.views.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.features.main.presentation.views.home.presentation.components.HomeViewBody
import com.route.e_commerce.features.main.presentation.views.home.presentation.view_model.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
    onCategoryViewAllClick: () -> Unit,
    onCategoryClick: (CategoryEntity) -> Unit,
    navController: NavController
) {

    LaunchedEffect(Unit) {
        homeViewModel.fetchCategories()
        homeViewModel.fetchNewArrivalsProducts()
        homeViewModel.fetchShoesProducts()
        homeViewModel.fetchElectronicsProducts()
    }
    HomeViewBody(
        modifier = modifier,
        homeViewModel = homeViewModel,
        navController = navController,
        onCategoryViewAllClick = onCategoryViewAllClick,
        onCategoryClick = onCategoryClick
    )
}