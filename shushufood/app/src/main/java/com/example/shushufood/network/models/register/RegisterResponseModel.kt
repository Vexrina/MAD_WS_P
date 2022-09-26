package com.example.shushufood.network.models.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponseModel(
    val token: String
)
