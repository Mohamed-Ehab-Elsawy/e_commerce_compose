package com.route.e_commerce.features.auth.forget_password.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.route.e_commerce.core.composables.CustomButton
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun ForgetPasswordButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    CustomButton(
        text = "Sent reset password email",
        textColor = primaryLight,
        backgroundColor = white,
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
    )
}