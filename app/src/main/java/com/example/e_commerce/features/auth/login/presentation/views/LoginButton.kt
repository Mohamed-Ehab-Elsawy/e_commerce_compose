package com.example.e_commerce.features.auth.login.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.e_commerce.R
import com.example.e_commerce.core.composables.CustomButton
import com.example.e_commerce.core.ui.theme.primaryLight
import com.example.e_commerce.core.ui.theme.white

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    CustomButton(
        text = stringResource(R.string.login),
        textColor = primaryLight,
        backgroundColor = white,
        onClick = onClick,
        modifier = modifier
    )
}