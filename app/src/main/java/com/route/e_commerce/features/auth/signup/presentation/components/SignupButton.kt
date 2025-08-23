package com.route.e_commerce.features.auth.signup.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.CustomButton
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun SignupButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    CustomButton(
        text = stringResource(R.string.sign_up),
        textColor = primaryLight,
        backgroundColor = white,
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
    )
}