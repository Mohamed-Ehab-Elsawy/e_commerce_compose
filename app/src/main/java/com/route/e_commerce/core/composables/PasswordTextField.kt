package com.route.e_commerce.core.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeHolderText: String = stringResource(R.string.enter_your_password),
    onGoAction: () -> Unit,
) {
    var hidePassword by remember { mutableStateOf(true) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.password),
            style = ECommerceTextStyles.text16
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            suffix = {
                if (hidePassword)
                    BuildSuffixIcon(iconRes = R.drawable.ic_closed_eye) {
                        hidePassword = false
                    }
                else
                    BuildSuffixIcon(iconRes = R.drawable.ic_eye) {
                        hidePassword = true
                    }
            },
            placeholder = {
                Text(
                    text = placeHolderText,
                    style = ECommerceTextStyles.text16.copy(color = Color.Gray)
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(onGo = {
                keyboardController?.hide()
                onGoAction.invoke()
            }),
            visualTransformation =
                if (hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun BuildSuffixIcon(
    @DrawableRes iconRes: Int,
    onClick: () -> Unit = {}
) {
    Icon(
        painter = painterResource(iconRes),
        contentDescription = null,
        tint = Color.Gray,
        modifier = Modifier.clickable { onClick.invoke() }
    )
}