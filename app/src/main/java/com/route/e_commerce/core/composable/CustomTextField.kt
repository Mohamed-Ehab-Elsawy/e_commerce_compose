package com.route.e_commerce.core.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    topTitleText: String,
    value: String,
    onValueChange: (String) -> Unit,
    suffixIcon: ImageVector,
    keyboardType: KeyboardType,
    hint: String
) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = topTitleText,
            style = ECommerceTextStyles.text16
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            suffix = {
                Icon(
                    imageVector = suffixIcon,
                    contentDescription = null,
                    tint = Color.Gray,
                )
            }, placeholder = {
                Text(
                    text = hint,
                    style = ECommerceTextStyles.text16.copy(color = Color.Gray)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}