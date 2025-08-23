package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun SoldText(
    modifier: Modifier = Modifier,
    sold: Int
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .border(
                1.dp,
                primaryLight.copy(0.5f),
                RoundedCornerShape(32.dp)
            )
    ) {
        Row(modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = stringResource(R.string.sold),
                style = ECommerceTextStyles.text14.copy(primaryLight)
            )
            Text(
                text = "$sold",
                style = ECommerceTextStyles.text14.copy(primaryLight)
            )
        }
    }

}