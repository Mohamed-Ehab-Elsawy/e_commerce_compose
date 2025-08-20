package com.example.e_commerce.features.auth.login.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.e_commerce.R
import com.example.e_commerce.core.navigation.ECommerceRoutes
import com.example.e_commerce.core.utils.ECommerceTextStyles

@Composable
fun CreateAccountButton(modifier: Modifier = Modifier, navController: NavController) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.don_t_have_an_account),
            style = ECommerceTextStyles.text16
        )
        TextButton(
            onClick = { navController.navigate(ECommerceRoutes.Signup.route) },
            modifier = Modifier.padding()
        ) {
            Text(
                stringResource(R.string.create_account),
                style = ECommerceTextStyles.text18.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}