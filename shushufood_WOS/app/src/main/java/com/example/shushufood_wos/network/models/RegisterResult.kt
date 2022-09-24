package com.example.shushufood_wos.network.models


sealed class RegisterResult {
    data class Ok(val token: String) : RegisterResult()
    object EmailIsNoValid : RegisterResult()
    object UserAlreadyExists : RegisterResult()
    object SomethingWentWrong : RegisterResult()
}