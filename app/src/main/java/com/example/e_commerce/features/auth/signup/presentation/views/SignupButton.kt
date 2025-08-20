package com.example.e_commerce.features.auth.signup.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.e_commerce.R
import com.example.e_commerce.core.composables.CustomButton
import com.example.e_commerce.core.ui.theme.primaryLight
import com.example.e_commerce.core.ui.theme.white

@Composable
fun SignupButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    CustomButton(
        text = stringResource(R.string.sign_up),
        textColor = primaryLight,
        backgroundColor = white,
        onClick = onClick,
        modifier = modifier
    )
}