package com.example.e_commerce.features.auth.forget_password.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.e_commerce.core.composables.EmailTextField
import com.example.e_commerce.core.composables.RouteLogo
import com.example.e_commerce.core.ui.theme.primaryLight

@Composable
fun ForgetPasswordViewBody(
    modifier: Modifier = Modifier, navController: NavController
) {
    var email by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RouteLogo()
        Spacer(modifier = Modifier.height(80.dp))
        Spacer(modifier = Modifier.height(32.dp))
        EmailTextField(
            emailValue = email,
            onValueChange = { email = it },
        )
        Spacer(modifier = Modifier.height(32.dp))
        ForgetPasswordButton {
            keyboardController?.hide()
            forgetPassword()
        }
    }
}

private fun forgetPassword() {
    //TODO: FORGET PASSWORD
}