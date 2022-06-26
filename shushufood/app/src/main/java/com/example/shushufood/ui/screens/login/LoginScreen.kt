package com.example.shushufood.ui.screens.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel
){
    val viewState = loginViewModel.viewState.observeAsState()
}