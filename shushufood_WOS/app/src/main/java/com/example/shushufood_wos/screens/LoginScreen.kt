package com.example.shushufood_wos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shushufood_wos.screens.loginsUtils.LoginViewModel
import com.example.shushufood_wos.screens.loginsUtils.LoginViewState
import com.example.shushufood_wos.theme.WearAppColorPalette
import com.example.shushufood_wos.utils.TextInput

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    val viewState = loginViewModel.viewState.observeAsState(LoginViewState())
    with(viewState.value){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(WearAppColorPalette.primary),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            item {
                TextInput(
                    header = "email",
                    textFieldValue = viewState.emailValue//viewState.emailValue,
                    onTextFieldChange = if (!viewState.isProgress) onLoginFieldChange.invoke(it)
                )
            }
        }
    }
}