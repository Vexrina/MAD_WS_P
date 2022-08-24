package com.example.shushufood.network.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    val token: String
)
