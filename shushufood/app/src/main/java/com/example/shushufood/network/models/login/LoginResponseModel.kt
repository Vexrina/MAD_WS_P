package com.example.shushufood.network.models.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    val token: String
)
