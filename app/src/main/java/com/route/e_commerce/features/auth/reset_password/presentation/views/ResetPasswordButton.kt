package com.route.e_commerce.features.auth.reset_password.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.composables.CustomButton
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun ResetPasswordButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    CustomButton(
        text = stringResource(R.string.reset_password),
        onClick = onClick, backgroundColor = white,
        textColor = primaryLight,
        enabled = enabled,
        modifier = modifier
    )
}