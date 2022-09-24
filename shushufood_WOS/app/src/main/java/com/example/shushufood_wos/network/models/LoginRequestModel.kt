package com.example.shushufood_wos.network.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
    val email: String,
    val password: String
)
