package com.route.e_commerce.features.auth.login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.route.e_commerce.R
import com.route.e_commerce.core.navigation.ECommerceRoutes
import com.route.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun ForgetPasswordTextButton(modifier: Modifier = Modifier, navController: NavController) {
    TextButton(onClick = {
        navController.navigate(ECommerceRoutes.ForgotPassword.route)
    }) {
        Text(
            text = stringResource(R.string.forget_password),
            style = ECommerceTextStyles.text16,
            textAlign = TextAlign.End,
            modifier = modifier.fillMaxWidth()
        )
    }
}