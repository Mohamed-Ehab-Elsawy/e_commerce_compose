package com.example.e_commerce.core.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.e_commerce.R

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    emailValue: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        topTitleText = stringResource(R.string.email),
        hint = stringResource(R.string.enter_your_email),
        suffixIcon = Icons.Rounded.Email,
        value = emailValue,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Email,
        modifier = modifier
    )
}