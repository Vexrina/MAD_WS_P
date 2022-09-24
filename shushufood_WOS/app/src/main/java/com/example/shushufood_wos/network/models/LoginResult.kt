package com.example.shushufood_wos.network.models

sealed class LoginResult {
    data class Ok(val token: String) : LoginResult()
    object UserNotFound : LoginResult()
    object InvalidPassword : LoginResult()
    object SomethingWentWrong : LoginResult()
}
