package com.example.shushufood.network.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
    val login: String,
    val password: String
)
