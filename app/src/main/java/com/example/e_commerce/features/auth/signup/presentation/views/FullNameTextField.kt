package com.example.e_commerce.features.auth.signup.presentation.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.e_commerce.R
import com.example.e_commerce.core.composables.CustomTextField

@Composable
fun FullNameTextField(
    modifier: Modifier = Modifier,
    fullNameValue: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        topTitleText = stringResource(R.string.full_name),
        hint = stringResource(R.string.enter_your_full_name),
        suffixIcon = Icons.Rounded.Person,
        value = fullNameValue,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Text,
        modifier = modifier
    )
}