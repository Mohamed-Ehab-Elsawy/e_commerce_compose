package com.route.e_commerce.features.auth.signup.presentation

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
import com.route.e_commerce.core.composables.LoadingIndicator
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.features.auth.signup.presentation.events.SignupEvent
import com.route.e_commerce.features.auth.signup.presentation.viewmodel.SignupViewModel
import com.route.e_commerce.features.auth.signup.presentation.views.SignupViewBody
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignupView(
    modifier: Modifier = Modifier,
    navController: NavController,
    signupViewModel: SignupViewModel = koinViewModel(),
) {
    val uiState by signupViewModel.uiState.collectAsState()
    val context = LocalContext.current

    Scaffold { paddingValues ->
        Box {
            SignupViewBody(
                modifier = modifier.padding(paddingValues),
                signupViewModel = signupViewModel
            )
            if (uiState is UiState.Loading)
                LoadingIndicator(modifier = Modifier.matchParentSize())
        }
    }

    LaunchedEffect(Unit) {
        signupViewModel.events.collect { event ->
            when (event) {
                is SignupEvent.NavigateToHome ->
                    navController.navigate(ECommerceRoutes.Home.route) {
                        popUpTo(ECommerceRoutes.Signup.route) {
                            inclusive = true
                        }
                    }

                is SignupEvent.ShowError ->
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}