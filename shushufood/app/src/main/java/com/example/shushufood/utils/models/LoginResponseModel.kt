package com.example.shushufood.utils.models

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseModel(
    val token: String
)
