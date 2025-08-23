package com.route.e_commerce.features.auth.forget_password.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.e_commerce.R
import com.route.e_commerce.core.composable.LoadingIndicator
import com.route.e_commerce.core.ui.theme.primaryLight
import com.route.e_commerce.core.utils.ECommerceTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpModalBottomSheet(
    isLoading: Boolean,
    onSubmit: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var otp by remember { mutableStateOf(List(6) { "" }) }

    val focusRequesters = List(6) { FocusRequester() }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        focusRequesters[0].requestFocus()
    }

    // Auto-submit when OTP is complete
    LaunchedEffect(otp) {
        val code = otp.joinToString("")
        if (code.length == 6 && code.all { it.isDigit() }) {
            onSubmit(code)
        }
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = primaryLight,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.enter_otp),
                style = ECommerceTextStyles.text18,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                otp.forEachIndexed { index, value ->
                    OtpSingleTextField(
                        value = value,
                        onValueChange = { newValue ->
                            val oldValue = otp[index]
                            otp = otp.toMutableList().also { it[index] = newValue }

                            when {
                                newValue.isNotEmpty() -> {
                                    if (index < 5) focusRequesters[index + 1].requestFocus()
                                    else focusManager.clearFocus()
                                }

                                newValue.isEmpty() && oldValue.isNotEmpty() -> {
                                    if (index > 0) focusRequesters[index - 1].requestFocus()
                                }
                            }
                        },
                        index = index,
                        focusRequesters = focusRequesters,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (isLoading) {
                LoadingIndicator()
            }
        }
    }
}