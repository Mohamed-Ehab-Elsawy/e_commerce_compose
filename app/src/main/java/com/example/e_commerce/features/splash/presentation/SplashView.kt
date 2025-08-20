package com.example.e_commerce.features.splash.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.e_commerce.features.splash.presentation.views.SplashViewBody

@Composable
fun SplashView(modifier: Modifier = Modifier, navController: NavController) =
    Scaffold { paddingValues ->
        SplashViewBody(
            modifier = modifier.padding(paddingValues),
            navController = navController
        )
    }