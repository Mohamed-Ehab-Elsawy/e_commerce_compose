package com.route.e_commerce.features.main.presentation.views.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.route.e_commerce.R
import com.route.e_commerce.core.data.entities.CategoryEntity
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun HomeCategorySection(
    modifier: Modifier = Modifier,
    categories: List<CategoryEntity>,
    onCategoryViewAllClick: () -> Unit,
    onCategoryClick: (CategoryEntity) -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(
                stringResource(R.string.categories),
                style = ECommerceTextStyles.text18.copy(color = primaryLight)
            )
            Text(
                text = stringResource(R.string.view_all),
                style = ECommerceTextStyles.text14.copy(color = primaryLight),
                modifier = Modifier.clickable(onClick = onCategoryViewAllClick)
            )
        }
        CategoriesHorizontalGrid(categories = categories) {
            onCategoryClick.invoke(it)
        }
    }
}