package com.example.e_commerce.features.auth.login.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.e_commerce.core.composables.LoadingIndicator
import com.example.e_commerce.core.navigation.ECommerceRoutes
import com.example.e_commerce.core.ui.UiState
import com.example.e_commerce.features.auth.login.presentation.events.LoginEvent
import com.example.e_commerce.features.auth.login.presentation.viewmodel.LoginViewModel
import com.example.e_commerce.features.auth.login.presentation.views.LoginViewBody
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginView(
    modifier: Modifier = Modifier, navController: NavController,
    loginViewModel: LoginViewModel = koinViewModel()
) {
    val uiState by loginViewModel.uiState.collectAsState()
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
                    navController.navigate(ECommerceRoutes.Home.route) {
                        popUpTo(ECommerceRoutes.Login.route) {
                            inclusive = true
                        }
                    }

                is LoginEvent.ShowError ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}