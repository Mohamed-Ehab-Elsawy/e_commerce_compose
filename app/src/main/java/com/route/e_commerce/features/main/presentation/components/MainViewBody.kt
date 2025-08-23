package com.route.e_commerce.features.main.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.route.e_commerce.R
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.features.main.presentation.views.categories.presentation.CategoriesView
import com.route.e_commerce.features.main.presentation.views.favourite.presentation.FavouriteView
import com.route.e_commerce.features.main.presentation.views.home.presentation.HomeView
import com.route.e_commerce.features.main.presentation.views.profile.presentation.ProfileView

@Composable
fun MainViewBody(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    navController: NavController,
    onCategoryViewAllClick: () -> Unit,
    onCategoryClick: (CategoryEntity) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .background(white)
    ) {
        Image(
            painter = painterResource(R.drawable.route_logo_bold),
            contentDescription = "route_logo",
            modifier = Modifier
                .padding(top = 50.dp)
                .width(80.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(20.dp))
        when (selectedIndex) {
            0 -> HomeView(
                navController = navController,
                onCategoryViewAllClick = {
                    onCategoryViewAllClick.invoke()
                },
                onCategoryClick = {
                    onCategoryClick.invoke(it)
                }
            )

            1 -> CategoriesView(
                navController = navController
            )

            2 -> FavouriteView(
                navController = navController
            )

            3 -> ProfileView(
                navController = navController
            )
        }
    }
}