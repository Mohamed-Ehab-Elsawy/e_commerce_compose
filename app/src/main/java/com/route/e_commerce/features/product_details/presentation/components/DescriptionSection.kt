package com.route.e_commerce.features.product_details.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.ExpandableText
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun DescriptionSection(
    modifier: Modifier = Modifier, description: String
) {
    Column {
        Text(
            text = stringResource(R.string.description),
            style = ECommerceTextStyles.text18.copy(primaryLight)
        )
        Spacer(Modifier.height(4.dp))
        ExpandableText(
            text = description
        )
    }
}