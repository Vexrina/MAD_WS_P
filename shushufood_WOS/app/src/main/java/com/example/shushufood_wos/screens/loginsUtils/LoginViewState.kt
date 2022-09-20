package com.example.shushufood_wos.screens.loginsUtils

sealed class LoginAction{
    data class OpenDashBoard(val username: String) : LoginAction()
    object None: LoginAction()
}

data class LoginViewState(
    val emailValue: String = "",
    val passwordValue: String = "",
    val isProgress: Boolean = false,
    val loginAction: LoginAction = LoginAction.None
)