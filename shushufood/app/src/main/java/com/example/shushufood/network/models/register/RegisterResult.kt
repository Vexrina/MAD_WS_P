package com.example.shushufood.network.models.register


sealed class RegisterResult {
    data class Ok(val token: String) : RegisterResult()
    object EmailIsNoValid : RegisterResult()
    object UserAlreadyExists : RegisterResult()
    object SomethingWentWrong : RegisterResult()
}