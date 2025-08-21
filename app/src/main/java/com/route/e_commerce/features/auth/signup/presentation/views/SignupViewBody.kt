package com.route.e_commerce.features.auth.signup.presentation.views

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
import com.route.e_commerce.core.composables.EmailTextField
import com.route.e_commerce.core.composables.PasswordTextField
import com.route.e_commerce.core.composables.RouteLogo
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.features.auth.signup.data.models.SignupRequest
import com.route.e_commerce.features.auth.signup.presentation.viewmodel.SignupViewModel

@Composable
fun SignupViewBody(
    modifier: Modifier = Modifier,
    signupViewModel: SignupViewModel
) {
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        RouteLogo()
        FullNameTextField(fullNameValue = fullName) { fullName = it }
        PhoneNumberTextField(phoneNumberValue = phoneNumber) { phoneNumber = it }
        EmailTextField(emailValue = email) { email = it }
        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            onGoAction = {
                signup(signupViewModel, fullName, phoneNumber, email, password)
            }
        )
        SignupButton(
            onClick = {
                keyboardController?.hide()
                signup(signupViewModel, fullName, phoneNumber, email, password)
            },
            enabled = (
                    fullName.isNotEmpty() && phoneNumber.isNotEmpty() &&
                            email.isNotEmpty() && password.isNotEmpty()
                    )
        )
    }
}

private fun signup(
    signupViewModel: SignupViewModel,
    fullName: String = "",
    phoneNumber: String = "",
    email: String = "",
    password: String = ""
) {
    if (fullName.isNotEmpty() && phoneNumber.isNotEmpty() &&
        email.isNotEmpty() && password.isNotEmpty()
    )
        signupViewModel.signup(
            SignupRequest(
                name = fullName,
                email = email,
                password = password,
                rePassword = password,
                phone = phoneNumber
            )
        )
}