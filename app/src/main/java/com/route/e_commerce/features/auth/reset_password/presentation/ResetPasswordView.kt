package com.route.e_commerce.features.auth.reset_password.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.route.e_commerce.core.composable.LoadingIndicator
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.core.utils.showToast
import com.route.e_commerce.features.auth.reset_password.presentation.components.ResetPasswordViewBody
import com.route.e_commerce.features.auth.reset_password.presentation.events.ResetPasswordEvents
import com.route.e_commerce.features.auth.reset_password.presentation.view_model.ResetPasswordViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResetPasswordView(
    modifier: Modifier = Modifier,
    navController: NavController,
    email: String,
    resetPasswordViewModel: ResetPasswordViewModel = koinViewModel()
) {
    val uiState by resetPasswordViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold { paddingValues ->
        Box {
            ResetPasswordViewBody(
                modifier = modifier.padding(paddingValues),
                email,
                resetPasswordViewModel
            )
            if (uiState is UiState.Loading) LoadingIndicator(modifier = Modifier.matchParentSize())
        }
    }

    LaunchedEffect(Unit) {
        resetPasswordViewModel.events.collect { event ->
            when (event) {
                ResetPasswordEvents.NavigateToLogin -> {
                    showToast(
                        context,
                        "Password changed successfully"
                    )
                    navController.navigate(ECommerceRoutes.Login.route) {
                        popUpTo(ECommerceRoutes.ResetPassword.route) {
                            inclusive = true
                        }
                    }
                }

                is ResetPasswordEvents.ShowError -> showToast(
                    context,
                    event.message
                )
            }
        }
    }
}