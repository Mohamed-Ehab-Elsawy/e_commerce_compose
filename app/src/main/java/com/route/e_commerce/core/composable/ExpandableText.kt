package com.route.e_commerce.core.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun ExpandableText(
    text: String,
    minimizedMaxLines: Int = 3
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = buildAnnotatedString {
                append(
                    if (expanded) text
                    else if (text.length > 100) text.take(100) + "..."
                    else text
                )
                if (text.length > 100) {
                    withStyle(style = SpanStyle(color = primaryLight)) {
                        append(if (expanded) "" else " Read More")
                    }
                }
            },
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            overflow = TextOverflow.Ellipsis,
            style = ECommerceTextStyles.text16.copy(primaryLight),
            modifier = Modifier.clickable {
                expanded = !expanded
            }
        )
    }
}