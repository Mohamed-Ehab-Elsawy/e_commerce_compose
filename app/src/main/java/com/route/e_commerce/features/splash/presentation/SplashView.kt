package com.route.e_commerce.features.splash.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.features.splash.presentation.components.SplashViewBody
import com.route.e_commerce.features.splash.presentation.events.SplashEvents
import com.route.e_commerce.features.splash.presentation.view_model.SplashViewModel
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashView(
    modifier: Modifier = Modifier,
    navController: NavController,
    splashViewModel: SplashViewModel = koinViewModel()
) {


    LaunchedEffect(Unit) {
        splashViewModel.fetchUserEntity()
    }

    Scaffold { paddingValues ->
        SplashViewBody(
            modifier = modifier.padding(paddingValues)
        )
    }


    LaunchedEffect(Unit) {
        splashViewModel.events.collect { event ->
            when (event) {
                SplashEvents.NavigateToHome -> {
                    delay(1000)
                    navController.navigate(ECommerceRoutes.Main.route) {
                        popUpTo(ECommerceRoutes.Splash.route) { inclusive = true }
                    }
                }

                SplashEvents.NavigateToLogin -> {
                    delay(1000)
                    navController.navigate(ECommerceRoutes.Login.route) {
                        popUpTo(ECommerceRoutes.Splash.route) { inclusive = true }
                    }
                }
            }
        }
    }
}