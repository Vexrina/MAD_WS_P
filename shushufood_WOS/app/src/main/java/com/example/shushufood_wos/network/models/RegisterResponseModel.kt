package com.example.shushufood_wos.network.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponseModel(
    val token: String
)
