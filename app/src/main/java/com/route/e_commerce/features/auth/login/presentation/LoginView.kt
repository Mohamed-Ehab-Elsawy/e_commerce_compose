package com.route.e_commerce.features.auth.login.presentation

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
import com.route.e_commerce.features.auth.login.presentation.components.LoginViewBody
import com.route.e_commerce.features.auth.login.presentation.events.LoginEvent
import com.route.e_commerce.features.auth.login.presentation.view_model.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginView(
    modifier: Modifier = Modifier, navController: NavController,
    loginViewModel: LoginViewModel = koinViewModel()
) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold { paddingValues ->
        Box {
            LoginViewBody(
                navController = navController,
                loginViewModel = loginViewModel,
                modifier = modifier.padding(paddingValues)
            )
            if (uiState is UiState.Loading)
                LoadingIndicator(modifier = Modifier.matchParentSize())

        }
    }
    LaunchedEffect(Unit) {
        loginViewModel.events.collect { event ->
            when (event) {
                is LoginEvent.NavigateToHome ->
                    navController.navigate(ECommerceRoutes.Main.route) {
                        popUpTo(ECommerceRoutes.Login.route) {
                            inclusive = true
                        }
                    }

                is LoginEvent.ShowError ->
                    showToast(
                        context,
                        event.message
                    )
            }
        }
    }
}