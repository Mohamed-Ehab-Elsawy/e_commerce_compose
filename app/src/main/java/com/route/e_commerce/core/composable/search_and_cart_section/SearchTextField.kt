package com.route.e_commerce.core.composable.search_and_cart_section

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.ui.theme.white
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
        },
        placeholder = {
            Text(
                "what are you looking for?",
                style = ECommerceTextStyles.text14.copy(
                    color = primaryLight
                )
            )
        },
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = primaryLight,
            focusedIndicatorColor = primaryLight,
            cursorColor = primaryLight,
            focusedContainerColor = white,
            unfocusedContainerColor = white,
        ),
        prefix = {
            SearchIcon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
            )
        },
        singleLine = true,
        modifier = modifier
    )
}