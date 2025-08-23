package com.route.e_commerce.features.main.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    onItemClick: (Int) -> Unit = {}
) {
    val items = listOf(
        R.drawable.ic_home,
        R.drawable.ic_categories,
        R.drawable.ic_favourite,
        R.drawable.ic_profile
    )

    BottomAppBar(
        containerColor = primaryLight,
        tonalElevation = 0.dp,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 42.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, icon ->
                if (selectedIndex == index) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(white),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = null,
                            tint = primaryLight,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                } else {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onItemClick.invoke(index)
                            }
                    )
                }
            }
        }
    }
}