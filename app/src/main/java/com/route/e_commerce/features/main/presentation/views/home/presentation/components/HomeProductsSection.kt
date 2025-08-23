package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.data.entities.ProductEntity
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun HomeProductsSection(
    modifier: Modifier = Modifier,
    title: String,
    products: List<ProductEntity>,
    onItemClick: (ProductEntity) -> Unit
) {
    Column(modifier) {
        Text(
            text = title, style = ECommerceTextStyles.text18.copy(
                color = primaryLight,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.height(16.dp))
        HomeProductsList(
            products = products,
            onItemClick = onItemClick
        )
    }
}