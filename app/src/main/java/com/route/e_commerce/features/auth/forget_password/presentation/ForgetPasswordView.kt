package com.route.e_commerce.features.auth.forget_password.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.route.e_commerce.core.composable.LoadingIndicator
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.core.ui.UiState
import com.route.e_commerce.core.utils.showToast
import com.route.e_commerce.features.auth.forget_password.data.models.VerifyOtpRequest
import com.route.e_commerce.features.auth.forget_password.presentation.components.ForgetPasswordViewBody
import com.route.e_commerce.features.auth.forget_password.presentation.components.OtpModalBottomSheet
import com.route.e_commerce.features.auth.forget_password.presentation.events.ForgetPasswordEvents
import com.route.e_commerce.features.auth.forget_password.presentation.view_model.ForgetPasswordViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForgetPasswordView(
    modifier: Modifier = Modifier,
    navController: NavController,
    forgetPasswordViewModel: ForgetPasswordViewModel = koinViewModel()
) {
    val uiState by forgetPasswordViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->
        Box {
            ForgetPasswordViewBody(
                modifier = modifier.padding(paddingValues),
                email = email,
                onEmailValueChange = { email = it },
                forgetPasswordViewModel = forgetPasswordViewModel
            )

            if (uiState is UiState.Loading && !showBottomSheet) {
                LoadingIndicator(modifier = Modifier.matchParentSize())
            }

            if (showBottomSheet) {
                OtpModalBottomSheet(
                    isLoading = uiState is UiState.Loading,
                    onSubmit = { otp ->
                        forgetPasswordViewModel.verifyOTP(
                            VerifyOtpRequest(resetCode = otp)
                        )
                    },
                    onDismiss = {
                        showBottomSheet = false
                    }
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        forgetPasswordViewModel.events.collect { event ->
            when (event) {
                is ForgetPasswordEvents.OpenOtpModalSheet -> showBottomSheet = true

                is ForgetPasswordEvents.ShowError -> showToast(context, event.message)

                is ForgetPasswordEvents.NavigateToResetPassword -> {
                    navController.navigate(
                        ECommerceRoutes.ResetPassword.passEmail(email = email)
                    ) {
                        popUpTo(ECommerceRoutes.ForgotPassword.route) { inclusive = true }
                    }
                }
            }
        }
    }
}