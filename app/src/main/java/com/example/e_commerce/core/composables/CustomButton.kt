package com.example.e_commerce.core.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(16.dp),
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = text,
            style = ECommerceTextStyles.text18.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}