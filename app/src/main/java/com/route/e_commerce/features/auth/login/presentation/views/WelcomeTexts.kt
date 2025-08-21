package com.route.e_commerce.features.auth.login.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun WelcomeTexts(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.welcome_back_to_route),
            style = ECommerceTextStyles.text24
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.please_sign_in_with_your_mail),
            style = ECommerceTextStyles.text16
        )
    }
}