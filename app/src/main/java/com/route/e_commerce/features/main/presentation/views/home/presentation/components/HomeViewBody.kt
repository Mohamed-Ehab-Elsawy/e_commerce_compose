package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.route.e_commerce.core.composable.search_and_cart_section.SearchAndCartSection
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.core.utils.showToast
import com.route.e_commerce.features.main.presentation.views.home.presentation.view_model.HomeViewModel

@Composable
fun HomeViewBody(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    navController: NavController,
    onCategoryViewAllClick: () -> Unit,
    onCategoryClick: (CategoryEntity) -> Unit
) {
    val context = LocalContext.current
    var categoriesList by remember { mutableStateOf(CategoryEntity.list) }
    var newArrivalsList by remember { mutableStateOf(ProductEntity.list) }
    var sportsProductsList by remember { mutableStateOf(ProductEntity.list) }
    var electronicsList by remember { mutableStateOf(ProductEntity.list) }
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(white)
    ) {
        item {
            SearchAndCartSection(
                onCartClick = { navController.navigate(ECommerceRoutes.Cart.route) }
            )
        }
        item { Spacer(Modifier.height(16.dp)) }
        item { HomeBannerSection() }
        item { Spacer(Modifier.height(16.dp)) }
        item {
            HomeCategorySection(
                onCategoryViewAllClick = { onCategoryViewAllClick.invoke() },
                onCategoryClick = { onCategoryClick.invoke(it) },
                categories = categoriesList
            )
        }
        item { Spacer(Modifier.height(16.dp)) }
        item {
            NewArrivalSection(
                products = newArrivalsList,
                onItemClick = { navigateToDetails(navController, it) }
            )
        }
        item { ShoesOfferBanner() }
        item {
            SportsProductsSection(
                products = sportsProductsList,
                onItemClick = { navigateToDetails(navController, it) }
            )
        }
        item { Spacer(Modifier.height(24.dp)) }
        item {
            ElectronicsSection(
                products = electronicsList,
                onItemClick = { navigateToDetails(navController, it) }
            )
        }
        item { Spacer(Modifier.height(16.dp)) }
    }

    LaunchedEffect(uiState) {
        when (val state = uiState.categories) {
            is UiState.Success -> if (state.data != null) categoriesList = state.data
            is UiState.Error -> showToast(context, state.t.localizedMessage)
            else -> {}
        }

        when (val state = uiState.newArrivals) {
            is UiState.Success -> if (state.data != null) newArrivalsList = state.data
            is UiState.Error -> showToast(context, state.t.localizedMessage)
            else -> {}
        }

        when (val state = uiState.shoes) {
            is UiState.Success -> if (state.data != null) sportsProductsList = state.data
            is UiState.Error -> showToast(context, state.t.localizedMessage)
            else -> {}
        }

        when (val state = uiState.electronics) {
            is UiState.Success -> if (state.data != null) electronicsList = state.data
            is UiState.Error -> showToast(context, state.t.localizedMessage)
            else -> {}
        }
    }

}

private fun navigateToDetails(
    navController: NavController,
    productEntity: ProductEntity
) {
    navController.navigate(
        ECommerceRoutes.ProductDetails
            .passProduct(productEntity)
    )
}