package com.example.e_commerce.features.auth.forget_password.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.e_commerce.features.auth.forget_password.presentation.view.ForgetPasswordViewBody

@Composable
fun ForgetPasswordView(
    modifier: Modifier = Modifier, navController: NavController
) {
    Scaffold { paddingValues ->
        ForgetPasswordViewBody(
            modifier = modifier.padding(paddingValues), navController = navController
        )
    }
}