package com.route.e_commerce.features.auth.forget_password.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.CustomButton
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun OtpSubmitButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    CustomButton(
        onClick = onClick,
        text = stringResource(R.string.submit),
        textColor = primaryLight,
        backgroundColor = white,
        modifier = modifier.fillMaxWidth()
    )
}