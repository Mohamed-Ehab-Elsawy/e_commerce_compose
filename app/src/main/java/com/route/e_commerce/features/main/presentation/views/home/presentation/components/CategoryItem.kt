package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.composable.NetworkImage
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryEntity: CategoryEntity,
    onCategoryClick: () -> Unit
) {
    Column(
        modifier = modifier
            .width(120.dp)
            .wrapContentHeight()
            .padding(4.dp)
            .clickable(onClick = onCategoryClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        NetworkImage(
            imageData = categoryEntity.image,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .clip(CircleShape)
        )
        Text(
            categoryEntity.name ?: "",
            style = ECommerceTextStyles.text14.copy(color = primaryLight),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}