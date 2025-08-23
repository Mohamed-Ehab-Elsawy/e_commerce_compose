package com.route.e_commerce.core.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun QuantityStepper(
    modifier: Modifier = Modifier,
    initialValue: Int = 1,
    minValue: Int = 1,
    maxValue: Int = 99,
    onValueChange: (Int) -> Unit = {}
) {
    var quantity by remember { mutableIntStateOf(initialValue) }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(primaryLight)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_rounded_circle_down),
            contentDescription = stringResource(R.string.decrease),
            tint = white,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    if (quantity > minValue) {
                        quantity--
                        onValueChange(quantity)
                    }
                }
        )
        Text(
            text = quantity.toString(),
            color = white,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Icon(
            painter = painterResource(R.drawable.ic_rounded_circle_up),
            contentDescription = stringResource(R.string.increase),
            tint = white,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    if (quantity < maxValue) {
                        quantity++
                        onValueChange(quantity)
                    }
                }
        )
    }
}