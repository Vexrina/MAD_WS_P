package com.example.shushufood_wos.screens.loginsUtils

sealed class LoginEvent{
    object LoginClicked: LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
}