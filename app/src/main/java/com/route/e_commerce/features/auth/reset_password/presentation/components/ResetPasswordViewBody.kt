package com.route.e_commerce.features.auth.reset_password.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.PasswordTextField
import com.route.e_commerce.core.composable.RouteLogo
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.features.auth.reset_password.data.models.ResetPasswordRequest
import com.route.e_commerce.features.auth.reset_password.presentation.view_model.ResetPasswordViewModel

@Composable
fun ResetPasswordViewBody(
    modifier: Modifier = Modifier,
    email: String,
    resetPasswordViewModel: ResetPasswordViewModel
) {
    var password by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RouteLogo()
        Spacer(modifier = Modifier.height(80.dp))
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            placeHolderText = stringResource(R.string.enter_your_new_password),
            onGoAction = {
                resetPassword(resetPasswordViewModel, email, password)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ResetPasswordButton(
            enabled = password.isNotEmpty(),
        ) {
            keyboardController?.hide()
            resetPassword(resetPasswordViewModel, email, password)
        }
    }
}

private fun resetPassword(
    resetPasswordViewModel: ResetPasswordViewModel,
    email: String,
    password: String
) {
    resetPasswordViewModel.resetPassword(
        resetPasswordRequest = ResetPasswordRequest(
            email,
            password
        )
    )
}