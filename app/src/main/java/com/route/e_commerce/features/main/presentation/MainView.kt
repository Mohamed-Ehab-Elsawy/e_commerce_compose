package com.route.e_commerce.features.main.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.features.main.presentation.components.HomeBottomBar
import com.route.e_commerce.features.main.presentation.components.MainViewBody

@Composable
fun MainView(
    modifier: Modifier = Modifier, navController: NavController
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            HomeBottomBar(
                selectedIndex = selectedIndex,
                onItemClick = { selectedIndex = it }
            )
        }
    ) { paddingValues ->
        MainViewBody(
            modifier = modifier.padding(bottom = paddingValues.calculateBottomPadding()),
            selectedIndex = selectedIndex,
            navController = navController,
            onCategoryViewAllClick = {
                selectedIndex = 1
            },
            onCategoryClick = {
                selectedIndex = 1
            }
        )
    }
}