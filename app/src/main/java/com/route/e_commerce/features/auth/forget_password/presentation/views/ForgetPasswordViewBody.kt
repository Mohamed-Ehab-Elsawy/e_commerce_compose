package com.route.e_commerce.features.auth.forget_password.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composables.EmailTextField
import com.route.e_commerce.core.composables.RouteLogo
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.features.auth.forget_password.data.models.SendResetPasswordEmailRequest
import com.route.e_commerce.features.auth.forget_password.presentation.view_model.ForgetPasswordViewModel

@Composable
fun ForgetPasswordViewBody(
    modifier: Modifier = Modifier,
    email: String,
    onEmailValueChange: (String) -> Unit,
    forgetPasswordViewModel: ForgetPasswordViewModel
) {

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
        Spacer(modifier = Modifier.height(32.dp))
        EmailTextField(
            emailValue = email,
            onValueChange = onEmailValueChange,
        )
        Spacer(modifier = Modifier.height(32.dp))
        ForgetPasswordButton(
            onClick = {
                keyboardController?.hide()
                forgetPassword(forgetPasswordViewModel, email)
            },
            enabled = email.isNotEmpty()
        )
    }
}

private fun forgetPassword(vm: ForgetPasswordViewModel, email: String) {
    if (email.isNotEmpty()) {
        vm.forgetPassword(SendResetPasswordEmailRequest(email))
    }
}