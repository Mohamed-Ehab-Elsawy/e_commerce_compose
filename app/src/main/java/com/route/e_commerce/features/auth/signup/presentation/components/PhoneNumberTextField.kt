package com.route.e_commerce.features.auth.signup.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.route.e_commerce.core.composable.CustomTextField

@Composable
fun PhoneNumberTextField(
    modifier: Modifier = Modifier,
    phoneNumberValue: String,
    onValueChange: (String) -> Unit
) {
    CustomTextField(
        topTitleText = "Phone Number",
        hint = "Enter your phone number",
        suffixIcon = Icons.Rounded.Phone,
        value = phoneNumberValue,
        onValueChange = onValueChange,
        keyboardType = KeyboardType.Phone,
        modifier = modifier
    )
}