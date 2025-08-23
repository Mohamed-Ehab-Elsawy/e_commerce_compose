package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.data.entities.CategoryEntity

@Composable
fun CategoriesHorizontalGrid(
    modifier: Modifier = Modifier,
    categories: List<CategoryEntity>,
    onCategoryClick: (CategoryEntity) -> Unit
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        items(categories.size) {
            CategoryItem(
                categoryEntity = categories[it],
                onCategoryClick = { onCategoryClick.invoke(categories[it]) }
            )
        }
    }
}