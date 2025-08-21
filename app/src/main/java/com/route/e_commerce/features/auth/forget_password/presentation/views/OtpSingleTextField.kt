package com.route.e_commerce.features.auth.forget_password.presentation.views

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.secondaryLight
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun OtpSingleTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    index: Int,
    focusRequesters: List<FocusRequester>,
    onDone: (KeyboardActionScope.() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 1) {
                onValueChange(newValue)
            }
        },
        singleLine = true,
        modifier = Modifier
            .width(50.dp)
            .height(60.dp)
            .focusRequester(focusRequesters[index]),
        textStyle = ECommerceTextStyles.text18.copy(
            textAlign = TextAlign.Center,
            color = primaryLight
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = if (index == 5) ImeAction.Done else ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = onDone
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = secondaryLight,
            focusedContainerColor = white
        )
    )
}