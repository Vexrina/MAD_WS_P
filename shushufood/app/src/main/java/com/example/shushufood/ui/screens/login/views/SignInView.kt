package com.example.shushufood.ui.screens.login.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shushufood.R
import com.example.shushufood.ui.components.DTextField
import com.example.shushufood.ui.screens.login.models.LoginViewState
import com.example.shushufood.ui.theme.AppTheme

@Composable
fun SignInView(
    viewState: LoginViewState,
    onTextFieldChange: (String)->Unit
){
    Column()
    {
        DTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            value = viewState.emailValue,
            onValueChange = onTextFieldChange,
            placeholder = stringResource(id = R.string.email_hint)
        )
    }
}